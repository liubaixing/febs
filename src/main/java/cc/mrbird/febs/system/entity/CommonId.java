package cc.mrbird.febs.system.entity;


import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 公共自增id表 Entity
 *
 * @author liubaixing
 * @date 2020-05-30 22:48:51
 */
@Data
@TableName("common_id")
public class CommonId {

    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 自增键名称
     */
    @TableField("name")
    private String name;

    /**
     * 自增数量
     */
    @TableField("num")
    private Integer num;

}
