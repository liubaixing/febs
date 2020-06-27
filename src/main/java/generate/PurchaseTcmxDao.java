package generate;

import generate.PurchaseTcmx;
import generate.PurchaseTcmxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PurchaseTcmxDao {
    long countByExample(PurchaseTcmxExample example);

    int deleteByExample(PurchaseTcmxExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PurchaseTcmx record);

    int insertSelective(PurchaseTcmx record);

    List<PurchaseTcmx> selectByExample(PurchaseTcmxExample example);

    PurchaseTcmx selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PurchaseTcmx record, @Param("example") PurchaseTcmxExample example);

    int updateByExample(@Param("record") PurchaseTcmx record, @Param("example") PurchaseTcmxExample example);

    int updateByPrimaryKeySelective(PurchaseTcmx record);

    int updateByPrimaryKey(PurchaseTcmx record);
}