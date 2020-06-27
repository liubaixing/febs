package generate;

import generate.PurchaseCg;
import generate.PurchaseCgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PurchaseCgDao {
    long countByExample(PurchaseCgExample example);

    int deleteByExample(PurchaseCgExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PurchaseCg record);

    int insertSelective(PurchaseCg record);

    List<PurchaseCg> selectByExample(PurchaseCgExample example);

    PurchaseCg selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PurchaseCg record, @Param("example") PurchaseCgExample example);

    int updateByExample(@Param("record") PurchaseCg record, @Param("example") PurchaseCgExample example);

    int updateByPrimaryKeySelective(PurchaseCg record);

    int updateByPrimaryKey(PurchaseCg record);
}