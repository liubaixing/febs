package generate;

import generate.PurchaseCgmx;
import generate.PurchaseCgmxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PurchaseCgmxDao {
    long countByExample(PurchaseCgmxExample example);

    int deleteByExample(PurchaseCgmxExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PurchaseCgmx record);

    int insertSelective(PurchaseCgmx record);

    List<PurchaseCgmx> selectByExample(PurchaseCgmxExample example);

    PurchaseCgmx selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PurchaseCgmx record, @Param("example") PurchaseCgmxExample example);

    int updateByExample(@Param("record") PurchaseCgmx record, @Param("example") PurchaseCgmxExample example);

    int updateByPrimaryKeySelective(PurchaseCgmx record);

    int updateByPrimaryKey(PurchaseCgmx record);
}