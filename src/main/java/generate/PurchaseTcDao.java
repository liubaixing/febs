package generate;

import generate.PurchaseTc;
import generate.PurchaseTcExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PurchaseTcDao {
    long countByExample(PurchaseTcExample example);

    int deleteByExample(PurchaseTcExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PurchaseTc record);

    int insertSelective(PurchaseTc record);

    List<PurchaseTc> selectByExample(PurchaseTcExample example);

    PurchaseTc selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PurchaseTc record, @Param("example") PurchaseTcExample example);

    int updateByExample(@Param("record") PurchaseTc record, @Param("example") PurchaseTcExample example);

    int updateByPrimaryKeySelective(PurchaseTc record);

    int updateByPrimaryKey(PurchaseTc record);
}