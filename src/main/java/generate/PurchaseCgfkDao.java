package generate;

import generate.PurchaseCgfk;
import generate.PurchaseCgfkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PurchaseCgfkDao {
    long countByExample(PurchaseCgfkExample example);

    int deleteByExample(PurchaseCgfkExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PurchaseCgfk record);

    int insertSelective(PurchaseCgfk record);

    List<PurchaseCgfk> selectByExample(PurchaseCgfkExample example);

    PurchaseCgfk selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PurchaseCgfk record, @Param("example") PurchaseCgfkExample example);

    int updateByExample(@Param("record") PurchaseCgfk record, @Param("example") PurchaseCgfkExample example);

    int updateByPrimaryKeySelective(PurchaseCgfk record);

    int updateByPrimaryKey(PurchaseCgfk record);
}