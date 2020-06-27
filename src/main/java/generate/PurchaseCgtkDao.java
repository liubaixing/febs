package generate;

import generate.PurchaseCgtk;
import generate.PurchaseCgtkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PurchaseCgtkDao {
    long countByExample(PurchaseCgtkExample example);

    int deleteByExample(PurchaseCgtkExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PurchaseCgtk record);

    int insertSelective(PurchaseCgtk record);

    List<PurchaseCgtk> selectByExample(PurchaseCgtkExample example);

    PurchaseCgtk selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PurchaseCgtk record, @Param("example") PurchaseCgtkExample example);

    int updateByExample(@Param("record") PurchaseCgtk record, @Param("example") PurchaseCgtkExample example);

    int updateByPrimaryKeySelective(PurchaseCgtk record);

    int updateByPrimaryKey(PurchaseCgtk record);
}