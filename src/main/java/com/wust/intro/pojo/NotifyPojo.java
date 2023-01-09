package com.wust.intro.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("notify")
public class NotifyPojo {
    @TableId(value="id",type= IdType.AUTO)
    private Integer id;
    @TableField("title")
    private String title;
    @TableField("date")
    private String date;
    @TableField("imgPath")
    private String impPath;
}
