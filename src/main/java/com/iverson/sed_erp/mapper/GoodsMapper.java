package com.iverson.sed_erp.mapper;

import com.iverson.sed_erp.pojo.Goods;
import com.iverson.sed_erp.provider.GoodsSqlProvider;
import com.iverson.sed_erp.vo.GoodsVo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface GoodsMapper {

    /**
     * 初始化商品
     * @param goods
     * @return
     */
    @Insert("insert into sed_market_goods values (#{id},#{goodsNo},#{name},#{barcode},#{weight},#{price},#{categoryNo},#{brandNo},#{store},#{createTime},#{modifyTime})")
    int addOne(Goods goods);

    /**
     * 更新商品信息
     * @param goods
     * @return
     */
    @UpdateProvider(type = GoodsSqlProvider.class, method = "updateGoodsByGoodsNo")
    int updateGoodsByGoodsNo(Goods goods);

    /**
     * 查询商品库存
     * @param goodsNo
     * @return
     */
    @Select("select store form sed_market_goods where goods_no=#{goodsNo}")
    int getStore(String goodsNo);

    /**
     * 条件查询商品列表
     * @param goodsNo
     * @param name
     * @param barcode
     * @param weight
     * @param price
     * @param categoryNo
     * @param brandNo
     * @return
     */
    @SelectProvider(type = GoodsSqlProvider.class, method = "getGoodsList")
    List<GoodsVo> searchGoods(@Param("goodsNo") String goodsNo,
                              @Param("name") String name,
                              @Param("barcode") String barcode,
                              @Param("weight") String weight,
                              @Param("price") String price,
                              @Param("categoryNo") String categoryNo,
                              @Param("brandNo") String brandNo);

    /**
     * 通过条形码查找商品信息
     * @param barcode
     * @return
     */
    @Select("select g.goods_no,g.name,g.barcode,g.weight,g.price,b.name as brand_name,c.name as category_name,g.store from " +
            "(sed_market_goods g left join sed_market_category c on g.category_no = c.category_no) " +
            "left join sed_market_brand b on g.brand_no = b.brand_no where g.barcode = #{barcode}")
    GoodsVo getGoodsByBarcode(String barcode);
}
