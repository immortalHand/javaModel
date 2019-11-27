package com.shop.common.utils;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationConstraint;
import org.apache.poi.ss.usermodel.DataValidationHelper;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Desc
 * @Author sinosoft-an
 * @Date 2019/2/24 16:34
 */
public class ExcelTemplateUtils {
    
	private static final Logger logger = LoggerFactory.getLogger(ExcelTemplateUtils.class);

    /**
     * @Title: createExcelTemplate
     * @Description: 生成Excel导入模板
     * @param @param filePath  Excel文件路径
     * @param @param handers   Excel列标题(数组)
     * @param @param downData  下拉框数据(数组)
     * @param @param downRows  下拉列的序号(数组,序号从0开始)
     * @return void
     * @throws
     */
    public static void createExcelTemplate(String filePath, String[] handers, String[][] excelDataArr, 
                                           List<String[]> downData, String[] downRows ,String[] sheetName){

        // 创建工作薄
        HSSFWorkbook wb = new HSSFWorkbook();

        // 表头样式
        HSSFCellStyle style = wb.createCellStyle();

        // 字体样式
        HSSFFont fontStyle = wb.createFont();
        fontStyle.setFontName("微软雅黑");
        fontStyle.setFontHeightInPoints((short)12);
        style.setFont(fontStyle);

        // 新建sheet
        HSSFSheet sheet1 = null;
        for(int i=0,len=sheetName.length ; i<len ; i++){
            sheet1 = wb.createSheet(""+sheetName[i]+"");
        }

        // 文本格式化
        HSSFCellStyle cellStyle2 = wb.createCellStyle();
        HSSFDataFormat format = wb.createDataFormat();
        cellStyle2.setDataFormat(format.getFormat("@"));
        cellStyle2.setFont(fontStyle);


        // 金额格式化
        HSSFCellStyle cellStyle3 = wb.createCellStyle();
        cellStyle3.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
        cellStyle3.setFont(fontStyle);

        // 费率格式化
        HSSFCellStyle cellStyle4 = wb.createCellStyle();
        cellStyle4.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.000000"));
        cellStyle4.setFont(fontStyle);

        // 生成sheet1内容
        // 第一个sheet的第一行为标题
        HSSFRow rowFirst = sheet1.createRow(0);
        // 写标题
        for(int i=0;i<handers.length;i++){
            // 获取第一行的每个单元格
            HSSFCell cell = rowFirst.createCell(i);
            // 设置每列的列宽
            sheet1.setColumnWidth(i, 4000);
            // 加样式
            cell.setCellStyle(style);
            // 往单元格里写数据
            cell.setCellValue(handers[i]);
            sheet1.setDefaultColumnStyle(i,cellStyle2);
        }
        // 写内容
		for (int j = 1; j < excelDataArr.length + 1; j++) {
			HSSFRow row = sheet1.createRow(j);// 从第二行开始赋值
			for (int k = 0; k < handers.length; k++) {
				HSSFCell cell = row.createCell(k); // 获取第一行的每个单元格
                // 设置每列的列宽
				sheet1.setColumnWidth(k, 4000);
                // 加样式
				cell.setCellStyle(style);
                // 往单元格里写数据
				cell.setCellValue(excelDataArr[j - 1][k]);

			}
		}

        // 设置下拉框数据
        String[] arr = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        int index = 0;
        HSSFRow row = null;
        for(int r=0;r<downRows.length;r++){
            // 获取下拉对象
            String[] dlData = downData.get(r);
            int rownum = Integer.parseInt(downRows[r]);
            // 255以内的下拉
            if(dlData.length < 255){
                // 255以内的下拉,参数分别是：作用的sheet、下拉内容数组、起始行、终止行、起始列、终止列
                try {
                    sheet1.addValidationData(setDataValidation(sheet1, dlData, 1, 50000, rownum ,rownum)); //超过255个报错
                } catch (Exception e) {
                    logger.error("createExcelTemplate方法里的sheet1.addValidationData报错，原因是：============================" + ExceptionUtils.getExceptionStackTraceString(e));
                }

            } else { //255以上的下拉，即下拉列表元素很多的情况
                //1、设置有效性
                //String strFormula = "Sheet2!$A$1:$A$5000" ; //Sheet2第A1到A5000作为下拉列表来源数据
                String strFormula = "Sheet2!$"+arr[index]+"$1:$"+arr[index]+"$5000"; //Sheet2第A1到A5000作为下拉列表来源数据
                sheet1.setColumnWidth(r, 4000); //设置每列的列宽
                //设置数据有效性加载在哪个单元格上,参数分别是：从sheet2获取A1到A5000作为一个下拉的数据、起始行、终止行、起始列、终止列
                sheet1.addValidationData(SetDataValidation(strFormula, 1, 50000, rownum, rownum)); //下拉列表元素很多的情况

                //2、生成sheet2内容
                for(int j=0;j<dlData.length;j++){
                    if(index==0){ //第1个下拉选项，直接创建行、列
                        row = sheet1.createRow(j); //创建数据行
                        sheet1.setColumnWidth(j, 4000); //设置每列的列宽
                        row.createCell(0).setCellValue(dlData[j]); //设置对应单元格的值

                    } else { //非第1个下拉选项

                        int rowCount = sheet1.getLastRowNum();
                        //System.out.println("========== LastRowNum =========" + rowCount);
                        if(j<=rowCount){ //前面创建过的行，直接获取行，创建列
                            //获取行，创建列
                            sheet1.getRow(j).createCell(index).setCellValue(dlData[j]); //设置对应单元格的值

                        } else { //未创建过的行，直接创建行、创建列
                            sheet1.setColumnWidth(j, 4000); //设置每列的列宽
                            //创建行、创建列
                            sheet1.createRow(j).createCell(index).setCellValue(dlData[j]); //设置对应单元格的值
                        }
                    }
                }

                index++;
            }

        }

        try {

            File f = new File(filePath); //写文件

            //不存在则新增
            if(!f.getParentFile().exists()){
                f.getParentFile().mkdirs();
            }
            if(!f.exists()){
                f.createNewFile();
            }

            FileOutputStream out = new FileOutputStream(f);
            out.flush();
            wb.write(out);
            out.close();
        } catch (FileNotFoundException e) {
            logger.error("生成Excel导入模板异常"+ExceptionUtils.getExceptionStackTraceString(e));
        } catch (IOException e) {
            logger.error("生成Excel导入模板异常"+ExceptionUtils.getExceptionStackTraceString(e));
        }
    }


    /**
     *
     * @Title: SetDataValidation
     * @Description: 下拉列表元素很多的情况 (255以上的下拉)
     * @param @param strFormula
     * @param @param firstRow   起始行
     * @param @param endRow     终止行
     * @param @param firstCol   起始列
     * @param @param endCol     终止列
     * @param @return
     * @return HSSFDataValidation
     * @throws
     */
    private static HSSFDataValidation SetDataValidation(String strFormula,
                                                        int firstRow, int endRow, int firstCol, int endCol) {

        // 设置数据有效性加载在哪个单元格上。四个参数分别是：起始行、终止行、起始列、终止列
        CellRangeAddressList regions = new CellRangeAddressList(firstRow, endRow, firstCol, endCol);
        DVConstraint constraint = DVConstraint.createFormulaListConstraint(strFormula);
        HSSFDataValidation dataValidation = new HSSFDataValidation(regions,constraint);

        dataValidation.createErrorBox("Error", "Error");
        dataValidation.createPromptBox("", null);

        return dataValidation;
    }


    /**
     *
     * @Title: setDataValidation
     * @Description: 下拉列表元素不多的情况(255以内的下拉)
     * @param @param sheet
     * @param @param textList
     * @param @param firstRow
     * @param @param endRow
     * @param @param firstCol
     * @param @param endCol
     * @param @return
     * @return DataValidation
     * @throws
     */
    private static DataValidation setDataValidation(Sheet sheet, String[] textList, int firstRow, int endRow, int firstCol, int endCol) {

        DataValidationHelper helper = sheet.getDataValidationHelper();
        //加载下拉列表内容
        DataValidationConstraint constraint = helper.createExplicitListConstraint(textList);
        //DVConstraint constraint = new DVConstraint();
        constraint.setExplicitListValues(textList);

        //设置数据有效性加载在哪个单元格上。四个参数分别是：起始行、终止行、起始列、终止列
        CellRangeAddressList regions = new CellRangeAddressList( firstRow, endRow,  firstCol,  endCol);

        //数据有效性对象
        DataValidation data_validation = helper.createValidation(constraint, regions);
        //DataValidation data_validation = new DataValidation(regions, constraint);

        return data_validation;
    }

    /**
     * @Title: getExcel
     * @Description: 下载指定路径的Excel文件
     * @param @param url 文件路径
     * @param @param fileName  文件名
     * @param @param response
     * @return void
     * @throws
     */
    public static void getExcel(String url, String fileName, HttpServletResponse response,HttpServletRequest request){

        try {

            //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
            response.setContentType("multipart/form-data");

            //2.设置文件头：最后一个参数是设置下载文件名
            response.setHeader("Content-disposition", "attachment; filename=\""
                    + encodeChineseDownloadFileName(request, fileName+".xls") +"\"");
//            response.setHeader("Content-Disposition", "attachment;filename="
//                    + new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + ".xls"); //中文文件名

            //通过文件路径获得File对象
            File file = new File(url);

            FileInputStream in = new FileInputStream(file);
            //3.通过response获取OutputStream对象(out)
            OutputStream out = new BufferedOutputStream(response.getOutputStream());

            int b = 0;
            byte[] buffer = new byte[2048];
            while ((b=in.read(buffer)) != -1){
                out.write(buffer,0,b); //4.写到输出流(out)中
            }

            in.close();
            out.flush();
            out.close();

        } catch (IOException e) {
            // log.error("下载Excel模板异常", e);
        }
    }

    /**
     *
     * @Title: encodeChineseDownloadFileName
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @param request
     * @param @param pFileName
     * @param @return
     * @param @throws UnsupportedEncodingException
     * @return String
     * @throws
     */
    private static String encodeChineseDownloadFileName(HttpServletRequest request, String pFileName)
            throws UnsupportedEncodingException {

        String filename = null;
        String agent = request.getHeader("USER-AGENT");
        //System.out.println("agent==========》"+agent);

        if (null != agent) {
            if (-1 != agent.indexOf("Firefox")) {//Firefox
                filename = "=?UTF-8?B?" + (new String(org.apache.commons.codec.binary.Base64.encodeBase64(pFileName.getBytes("UTF-8")))) + "?=";
            } else if (-1 != agent.indexOf("Chrome")) {//Chrome
                filename = new String(pFileName.getBytes(), "ISO8859-1");
            } else {//IE7+
                filename = java.net.URLEncoder.encode(pFileName, "UTF-8");
                filename = StringUtils.replace(filename, "+", "%20");//替换空格
            }
        } else {
            filename = pFileName;
        }

        return filename;
    }


    /**
     * 读取Excel的内容，第一维数组存储的是一行中格列的值，二维数组存储的是多少个行
     * @param file 读取数据的源Excel
     * @param ignoreRows 读取数据忽略的行数，比喻行头不需要读入 忽略的行数为1
     * @return 读出的Excel中数据的内容
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static String[][] getData(File file, int ignoreRows)
            throws FileNotFoundException, IOException {
        List<String[]> result = new ArrayList<String[]>();
        int rowSize = 0;
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(
                file));
        // 打开HSSFWorkbook
        POIFSFileSystem fs = new POIFSFileSystem(in);
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        HSSFCell cell = null;
        int sheetIndex = 0;
        HSSFSheet st = wb.getSheetAt(sheetIndex);
        // 第一行为标题，不取
        for (int rowIndex = ignoreRows; rowIndex <= st.getLastRowNum(); rowIndex++) {
            HSSFRow row = st.getRow(rowIndex);
            if (row == null) {
                continue;
            }
            int tempRowSize = row.getLastCellNum() + 1;
            if (tempRowSize > rowSize) {
                rowSize = tempRowSize;
            }
            String[] values = new String[rowSize];
            Arrays.fill(values, "");
            boolean hasValue = false;
            for (short columnIndex = 0; columnIndex <= row.getLastCellNum(); columnIndex++) {
                String value = "";
                cell = row.getCell(columnIndex);
                if (cell != null) {
                    // 注意：一定要设成这个，否则可能会出现乱码
                    //cell.setEncoding(HSSFCell.ENCODING_UTF_16);
                    switch (cell.getCellType()) {
                        case HSSFCell.CELL_TYPE_STRING:
                            value = cell.getStringCellValue();
                            break;
                        case HSSFCell.CELL_TYPE_NUMERIC:
                            if (HSSFDateUtil.isCellDateFormatted(cell)) {
                                Date date = cell.getDateCellValue();
                                if (date != null) {
                                    value = new SimpleDateFormat("yyyy-MM-dd")
                                            .format(date);
                                } else {
                                    value = "";
                                }
                            } else {
                                Object inputValue = null;// 单元格值
                                Long longVal = Math.round(cell.getNumericCellValue());
                                Double doubleVal = cell.getNumericCellValue();
                                if(Double.parseDouble(longVal + ".0") != doubleVal){   //判断是否含有小数位.0
                                    inputValue = longVal;
                                    if(String.valueOf(cell.getNumericCellValue()).indexOf(".") > -1){
                                        String[] str = String.valueOf(cell.getNumericCellValue()).split("\\.");
                                        switch (str[1].length()){
                                            case 1:
                                                value = new DecimalFormat("0.0").format(cell
                                                        .getNumericCellValue());
                                            case 2:
                                                value = new DecimalFormat("0.00").format(cell
                                                        .getNumericCellValue());
                                                break;
                                            case 3:
                                                value = new DecimalFormat("0.000").format(cell
                                                        .getNumericCellValue());
                                                break;
                                            case 4:
                                                value = new DecimalFormat("0.0000").format(cell
                                                        .getNumericCellValue());
                                                break;
                                            case 5:
                                                value = new DecimalFormat("0.00000").format(cell
                                                        .getNumericCellValue());
                                                break;
                                            case 6:
                                                value = new DecimalFormat("0.000000").format(cell
                                                        .getNumericCellValue());
                                                break;
                                            default:
                                                value = new DecimalFormat("0").format(cell
                                                        .getNumericCellValue());
                                        }
                                    }else{
                                        value = new DecimalFormat("0").format(inputValue);
                                    }
                                }
                                else{
                                    inputValue = doubleVal;
                                    value = new DecimalFormat("0").format(inputValue);
                                }

                            }
                            break;
                        case HSSFCell.CELL_TYPE_FORMULA:
                            // 导入时如果为公式生成的数据则无值
                            if (!cell.getStringCellValue().equals("")) {
                                value = cell.getStringCellValue();
                            } else {
                                value = cell.getNumericCellValue() + "";
                            }
                            break;
                        case HSSFCell.CELL_TYPE_BLANK:
                            break;
                        case HSSFCell.CELL_TYPE_ERROR:
                            value = "";
                            break;
                        case HSSFCell.CELL_TYPE_BOOLEAN:
                            value = (cell.getBooleanCellValue() == true ? "Y"
                                    : "N");
                            break;
                        default:
                            value = "";
                    }
                }
                if (columnIndex == 0 && value.trim().equals("")) {
                    break;
                }
                values[columnIndex] = rightTrim(value);
                hasValue = true;
            }

            if (hasValue) {
                result.add(values);
            }
        }
        in.close();
        String[][] returnArray = new String[result.size()][rowSize];
        for (int i = 0; i < returnArray.length; i++) {
            returnArray[i] = (String[]) result.get(i);
        }
        return returnArray;
    }

    /**
     * 去掉字符串右边的空格
     * @param str 要处理的字符串
     * @return 处理后的字符串
     */
    public static String rightTrim(String str) {
        if (str == null) {
            return "";
        }
        int length = str.length();
        for (int i = length - 1; i >= 0; i--) {
            if (str.charAt(i) != 0x20) {
                break;
            }
            length--;
        }
        return str.substring(0, length);
    }


    /**
     * @Title: getExcelTemplate
     * @Description: 生成Excel模板并导出
     * @param @param uuid
     * @param @param request
     * @param @param response
     * @param @return
     * @return Data
     * @throws
     */
    @RequestMapping("/getExcelTemplate")
    //@Test
    public  static void main(String[] args){

        String[] fileName = {"员工信息表"}; //模板名称
        String[] handers = {"姓名","性别","证件类型","证件号码","服务结束时间","参保地","民族"}; //列标题
        String[][] excelDataArr = {};
        //下拉框数据
        List<String[]> downData = new ArrayList();
        String[] str1 = {"男","女","未知"};
        String[] str2 = {"北京","上海","广州","深圳","武汉","长沙","湘潭"};
        String[] str3 = {"01-汉族","02-蒙古族","03-回族","04-藏族","05-维吾尔族","06-苗族","07-彝族","08-壮族","09-布依族","10-朝鲜族",
                "11-满族","12-侗族","13-瑶族","14-白族","15-土家族","16-哈尼族","17-哈萨克族","18-傣族","19-黎族","20-傈僳族",
                "21-佤族","22-畲族","23-高山族","24-拉祜族","25-水族","26-东乡族","27-纳西族","28-景颇族","29-柯尔克孜族","30-土族",
                "31-达斡尔族","32-仫佬族","33-羌族","34-布朗族","35-撒拉族","36-毛难族","37-仡佬族","38-锡伯族","39-阿昌族","40-普米族",
                "41-塔吉克族","42-怒族","43-乌孜别克族","44-俄罗斯族","45-鄂温克族","46-德昂族","47-保安族","48-裕固族","49-京族","50-塔塔尔族",
                "51-独龙族","52-鄂伦春族","53-赫哲族","54-门巴族","55-珞巴族","56-基诺族","98-外国血统","99-其他"};
        downData.add(str1);
        downData.add(str2);
        downData.add(str3);
        String [] downRows = {"1","5","6"}; //下拉的列序号数组(序号从0开始)

        try {


            ExcelTemplateUtils.createExcelTemplate("E://1.xls", handers, excelDataArr, downData, downRows ,fileName);
        } catch (Exception e) {
             logger.error("批量导入信息异常：" + e.getMessage());
        }
    }
	
}
