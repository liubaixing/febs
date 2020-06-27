package generate;

import generate.PurchaseCgfpmx;
import generate.PurchaseCgfpmxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PurchaseCgfpmxDao {
    long countByExample(PurchaseCgfpmxExample example);

    int deleteByExample(PurchaseCgfpmxExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PurchaseCgfpmx record);

    int insertSelective(PurchaseCgfpmx record);

    List<PurchaseCgfpmx> selectByExample(PurchaseCgfpmxExample example);

    PurchaseCgfpmx selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PurchaseCgfpmx record, @Param("example") PurchaseCgfpmxExample example);

    int updateByExample(@Param("record") PurchaseCgfpmx record, @Param("example") PurchaseCgfpmxExample example);

    int updateByPrimaryKeySelective(PurchaseCgfpmx record);

    int updateByPrimaryKey(PurchaseCgfpmx record);
}