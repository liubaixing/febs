package generate;

import generate.PurchaseCgtkmx;
import generate.PurchaseCgtkmxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PurchaseCgtkmxDao {
    long countByExample(PurchaseCgtkmxExample example);

    int deleteByExample(PurchaseCgtkmxExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PurchaseCgtkmx record);

    int insertSelective(PurchaseCgtkmx record);

    List<PurchaseCgtkmx> selectByExample(PurchaseCgtkmxExample example);

    PurchaseCgtkmx selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PurchaseCgtkmx record, @Param("example") PurchaseCgtkmxExample example);

    int updateByExample(@Param("record") PurchaseCgtkmx record, @Param("example") PurchaseCgtkmxExample example);

    int updateByPrimaryKeySelective(PurchaseCgtkmx record);

    int updateByPrimaryKey(PurchaseCgtkmx record);
}