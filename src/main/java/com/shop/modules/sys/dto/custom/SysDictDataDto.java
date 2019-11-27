package com.shop.modules.sys.dto.custom;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.shop.modules.sys.dto.domain.SysDictDataDtoBase;
import com.shop.modules.sys.dto.domain.SysDictDataDtoBase;

import java.io.Serializable;
import java.util.Date;

/**
 * 字典数据表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-02-23 16:16:05
 */
@TableName("sys_dict_data")
public class SysDictDataDto extends SysDictDataDtoBase implements Serializable {

	private static final long serialVersionUID = 1L;

}
