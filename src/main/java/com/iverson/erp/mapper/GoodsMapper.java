package com.iverson.erp.mapper;

import com.iverson.erp.vo.GoodsVO;
import com.iverson.erp.pojo.Goods;
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
    @Insert("insert into sed_market_goods(goods_no,name,barcode,weight,price,category_no,brand_no,store) values (#{goodsNo},#{name},#{barcode},#{weight},#{price},#{categoryNo},#{brandNo},#{store})")
    int addOne(Goods goods);

    /**
     * 更新商品信息
     * @param goods
     * @return
     */
    @UpdateProvider(type = GoodsSqlProvider.class, method = "getUpdateSql")
    int update(Goods goods);

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
     * @param categoryNo
     * @param brandNo
     * @return
     */
    @SelectProvider(type = GoodsSqlProvider.class, method = "getListSql")
    List<GoodsVO> getList(@Param("goodsNo") String goodsNo,
                          @Param("name") String name,
                          @Param("barcode") String barcode,
                          @Param("categoryNo") String categoryNo,
                          @Param("brandNo") String brandNo);

    /**
     * 通过条形码查找商品信息
     * @param barcode
     * @return
     */
    @Select("select g.goods_no,g.name,g.barcode,g.weight,g.price,g.brand_no,b.name as brand_name,g.category_no,c.name as category_name,g.store from " +
            "(sed_market_goods g left join sed_market_category c on g.category_no = c.category_no) " +
            "left join sed_market_brand b on g.brand_no = b.brand_no where g.barcode = #{barcode}")
    GoodsVO getGoodsByBarcode(String barcode);

    @Select("select * from sed_market where goods_no=#{goodsNo}")
    Goods getGoodsByNo(String goodsNo);

    class GoodsSqlProvider {
        public String getUpdateSql(Goods goods){

            StringBuffer sql = new StringBuffer("update sed_market_goods set ");
            if(goods.getName() != null){
                sql.append("name=#{name},");
            }
            if(goods.getBarcode() != null){
                sql.append("barcode=#{barcode},");
            }
            if(goods.getCategoryNo() != null){
                sql.append("category_no=#{categoryNo},");
            }
            if(goods.getBrandNo() != null){
                sql.append("brand_no=#{brandNo},");
            }
            if(goods.getStore() != null){
                sql.append("store=#{store},");
            }
            sql.replace(sql.length() - 1,sql.length(),"");
            sql.append(" where goods_no=#{goodsNo}");
            return sql.toString();
        }

        public String getListSql(@Param("goodsNo") String goodsNo,
                                 @Param("name") String name,
                                 @Param("barcode") String barcode,
                                 @Param("categoryNo") String categoryNo,
                                 @Param("brandNo") String brandNo){
            String str = "select g.goods_no,g.name,g.barcode,g.weight,g.price,g.brand_no,b.name as brand_name,g.category_no,c.name as category_name,g.store " +
                    "from (sed_market_goods g left join sed_market_category c on g.category_no = c.category_no) " +
                    "left join sed_market_brand b on g.brand_no = b.brand_no " +
                    "where 1=1 ";
            StringBuffer sql = new StringBuffer(str);
            if(goodsNo != null){
                sql.append(" and g.goods_no like CONCAT('%',#{goodsNo},'%')");
            }
            if(name != null){
                sql.append(" and g.name like CONCAT('%',#{name},'%')");
            }
            if(barcode != null){
                sql.append(" and g.barcode like CONCAT('%',#{barcode},'%')");
            }
            if(categoryNo != null){
                sql.append(" and g.category_no like CONCAT('%',#{categoryNo},'%')");
            }
            if(brandNo != null){
                sql.append(" and g.brand_no like CONCAT('%',#{brandNo},'%')");
            }
            return sql.toString();
        }
    }
}
