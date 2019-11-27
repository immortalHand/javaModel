/**
 * Copyright 2018 人人开源 http://www.renren.io
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.shop.modules.sys.dto.custom;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.shop.modules.sys.dto.domain.SysCaptchaDtoBase;
import com.shop.modules.sys.dto.domain.SysCaptchaDtoBase;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统验证码
 * @author Mark sunlightcs@gmail.com
 * @since 2.0.0 2018-02-10
 */
@TableName("sys_captcha")
public class SysCaptchaDto extends SysCaptchaDtoBase implements Serializable {

    private static final long serialVersionUID = 1L;

}
