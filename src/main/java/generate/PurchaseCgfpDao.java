package generate;

import generate.PurchaseCgfp;
import generate.PurchaseCgfpExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PurchaseCgfpDao {
    long countByExample(PurchaseCgfpExample example);

    int deleteByExample(PurchaseCgfpExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PurchaseCgfp record);

    int insertSelective(PurchaseCgfp record);

    List<PurchaseCgfp> selectByExample(PurchaseCgfpExample example);

    PurchaseCgfp selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PurchaseCgfp record, @Param("example") PurchaseCgfpExample example);

    int updateByExample(@Param("record") PurchaseCgfp record, @Param("example") PurchaseCgfpExample example);

    int updateByPrimaryKeySelective(PurchaseCgfp record);

    int updateByPrimaryKey(PurchaseCgfp record);
}