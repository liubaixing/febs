package generate;

import generate.PurchaseCgfkmx;
import generate.PurchaseCgfkmxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PurchaseCgfkmxDao {
    long countByExample(PurchaseCgfkmxExample example);

    int deleteByExample(PurchaseCgfkmxExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PurchaseCgfkmx record);

    int insertSelective(PurchaseCgfkmx record);

    List<PurchaseCgfkmx> selectByExample(PurchaseCgfkmxExample example);

    PurchaseCgfkmx selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PurchaseCgfkmx record, @Param("example") PurchaseCgfkmxExample example);

    int updateByExample(@Param("record") PurchaseCgfkmx record, @Param("example") PurchaseCgfkmxExample example);

    int updateByPrimaryKeySelective(PurchaseCgfkmx record);

    int updateByPrimaryKey(PurchaseCgfkmx record);
}