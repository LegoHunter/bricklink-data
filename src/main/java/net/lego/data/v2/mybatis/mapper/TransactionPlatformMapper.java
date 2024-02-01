package net.lego.data.v2.mybatis.mapper;

import net.lego.data.v2.dto.TransactionPlatform;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Optional;

public interface TransactionPlatformMapper {
    @Insert("""
            INSERT INTO transaction_platform (transaction_platform_code, transaction_platform_name) \
            VALUES (#{transactionPlatformCode}, #{transactionPlatformName})\
            """)
    void insert(TransactionPlatform transactionPlatform);

    @Update("""
            UPDATE transaction_platform SET transaction_platform_name = #{transactionPlatformName} \
            WHERE transaction_platform_code = #{transactionPlatformCode}\
            """)
    void update(TransactionPlatform transactionPlatform);

    @Select("""
            SELECT transaction_platform_code, \
                   transaction_platform_name \
            FROM transaction_platform \
            """)
    @ResultMap("transactionPlatformResultMap")
    List<TransactionPlatform> findAll();

    @Select("""
            SELECT transaction_platform_code, \
                   transaction_platform_name \
            FROM transaction_platform \
            WHERE transaction_platform_code = #{transactionPlatformCode}\
            """)
    @ResultMap("transactionPlatformResultMap")
    Optional<TransactionPlatform> findTransactionPlatformByCode(String transactionPlatformCode);
}
