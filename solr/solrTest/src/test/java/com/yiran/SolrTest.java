package com.yiran;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class SolrTest {

    /*
    * 添加文档
    * */
    @Test
    public void testAddDocument() throws Exception{
        // 创建一个SolrServer对象，使用HttpSolrServer
        SolrServer solrServer = new HttpSolrServer("http://192.168.13.25:8080/solr");
        // 创建文档对象。必须包含ID域
        SolrInputDocument document = new SolrInputDocument();
        // 向文档中添加域
        document.addField("id",1);
        document.addField("item_title","依然");
        document.addField("item_price", "198");
        // 将文档写入索引库
        solrServer.add(document);
        // 提交
        solrServer.commit();
    }

    /*
    * 修改文档，和添加文档一样，或者也可以用set(没试过)
    * */
    @Test
    public void testUpdateDocument(){}

    /*
    * 删除文档
    *   1.根据ID删除文档
    *   2.根据查询删除文档
    * */
    @Test
    public void testDelById() throws Exception {
        // 创建一个SolrServer对象，使用HttpSolrServer
        SolrServer solrServer = new HttpSolrServer("http://192.168.13.25:8080/solr");
        // 可以直接使用索引库删除,这里是字符串
        solrServer.deleteById("3");
        // 提交
        solrServer.commit();
    }
    @Test
    public void testDelByQuery() throws Exception{
        // 创建一个SolrServer对象，使用HttpSolrServer
        SolrServer solrServer = new HttpSolrServer("http://192.168.13.25:8080/solr");
        // 通过查询删除 // 如果属性中有空格，可能报错，可以进行模糊查询删除，就是只输入部分
        solrServer.deleteByQuery("title:你觉得");
        solrServer.commit();
    }

    /*
    * 查询索引库
    *   查询步骤：
    *       第一步：创建一个SolrServer对象
    *       第二步：创建一个SolrQuery对象。
    *       第三步：向SolrQuery中添加查询条件、过滤条件。。。
    *       第四步：执行查询。得到一个Response对象。
    *       第五步：取查询结果。
    *       第六步：遍历结果并打印。
    *
    *   查询还有更多的条件，例如分页之类的。
    * */
    @Test
    public void testQueryDocument()throws Exception{
        // 1.创建一个SolrServer对象，使用HttpSolrServer
        SolrServer solrServer = new HttpSolrServer("http://192.168.13.25:8080/solr");
        // 2.创建一个query对象
        SolrQuery query = new SolrQuery();
        // 3.像query对象中添加查询条件
        // item_keywords 关联了三个属性 item_title item_sell_point item_category_name
        query.setQuery("item_keywords:依然");
        // 4.执行查询得到一个QueryResponse对象
        QueryResponse response = solrServer.query(query);
        // 5.取出查询结果
        SolrDocumentList list = response.getResults();
        // 6.遍历，打印结果集 get方法，根据key获取val  不存在返回null
        for (SolrDocument document : list){
            System.out.println(document.get("id"));
            System.out.println(document.get("item_title"));
            System.out.println(document.get("item_sell_point"));
            System.out.println(document.get("item_category_name"));
        }
    }

    /*
    * 带高亮显示查询
    *   很明显，很麻烦，输出是个逆序的，所谓高亮也就是给加了个em标签而已
    * */
    @Test
    public void testQueryDocumentBuHeightLighting()throws Exception{
        //1、创建一个SolrServer对象
        SolrServer solrServer = new HttpSolrServer("http://192.168.13.25:8080/solr");
        //2、创建一个SolrQuery对象
        SolrQuery query = new SolrQuery();
        //3、向SolrQuery中添加查询条件
        query.setQuery("item_title:依然");
        //指定默认搜索域
        query.set("df", "item_keywords");
        //开启高亮显示
        query.setHighlight(true);
        //设置高亮显示的域
        query.addHighlightField("item_title");
        query.setHighlightSimplePre("<em>");
        query.setHighlightSimplePost("</em>");
        //4、执行查询得到一个QueryResponse对象
        QueryResponse response = solrServer.query(query);
        //5、取出查询结果
        SolrDocumentList list = response.getResults();
        //6、遍历打印查询结果
        for (SolrDocument solrDocument : list) {
            System.out.println(solrDocument.get("id"));
            //取高亮显示
            Map<String,Map<String,List<String>>> heightLinghting = response.getHighlighting();
            List<String> hlist = heightLinghting.get(solrDocument.get("id")).get("item_title");
            String itemTitle = null;
            if(hlist!=null && hlist.size()>0){
                itemTitle=hlist.get(0);
            }else{
                itemTitle = (String)solrDocument.get("item_title");
            }
            System.out.println(itemTitle);
            System.out.println(solrDocument.get("item_sell_point"));
            System.out.println(solrDocument.get("item_category_name"));
        }
    }

    /*
    * Order 排序
    * */
    @Test
    public void testQueryDocumentOrderByIdPage(){
        //1、创建一个SolrServer对象
        SolrServer solrServer = new HttpSolrServer("http://192.168.13.25:8080/solr");
        //2、创建一个SolrQuery对象
        SolrQuery query = new SolrQuery();
        // 3.按id进行逆序排列
        query.setSort("id", SolrQuery.ORDER.desc);
        // 4.设置分页查询
        // 开始索引 = pageSize*(pageNum-1)
        query.setStart(1);
        // 查询条数 = pageSize
        query.setRows(10);
    }

}