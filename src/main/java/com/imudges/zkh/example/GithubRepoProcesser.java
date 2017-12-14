package com.imudges.zkh.example;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

public class GithubRepoProcesser implements PageProcessor {

    /**
     * 一：抓取网站的相关配置，包括编码、重试次数、抓取间隔等
     */
    private Site site=Site.me().setRetryTimes(3).setSleepTime(1000);

    //process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
    public void process(Page page) {
        /**
         * 二：定义如何抽取页面信息，并保存下来
         */
        page.putField("author",page.getUrl().regex("https://github\\\\.com/(\\\\w+)/.*").toString());
        page.putField("name",page.getHtml().xpath("//h1[@class='entry-title public']/strong/a/text()").toString());
        if(page.getResultItems().get("name")==null){
            page.setSkip(true);
            //跳过该业
        }
        page.putField("readme",page.getHtml().xpath("//div[@id='readme']/tidyText()"));


        /**
         * 三：从页面发现后续的url地址来抓取
         */
        page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/[\\w\\-]+/[\\w\\-]+)").all());
    }

    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new GithubRepoProcesser())
                //从"https://github.com/code4craft"开始抓
                .addUrl("https://github.com/code4craft")
                .addPipeline(new ConsolePipeline())
                //开启5个线程抓取
                .thread(5)
                //启动爬虫
                .run();
    }
}