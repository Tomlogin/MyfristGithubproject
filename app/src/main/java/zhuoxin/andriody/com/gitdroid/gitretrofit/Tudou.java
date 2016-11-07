package zhuoxin.andriody.com.gitdroid.gitretrofit;

import java.util.List;

/**
 * Created by Administrator on 9/29 0029.
 */
public class Tudou {


    /**
     * resultcode : 200
     * reason : Success
     * result : {"data":[{"id":"25","title":"酸辣土豆丝","tags":"家常菜;热菜;增肥;酸辣;炒;秋季养生;秋季菜谱;健脾;祛风散寒;祛寒;健脾胃;助睡眠;脾虚","imtro":"酸辣土豆丝可谓是人见人爱的一道家常菜，虽然价格便宜但是酸辣可口味道味道却是大家喜爱的。无论是家庭餐桌、还是饭馆酒店几乎都能见到它的身影，虽然酸辣土豆丝是一道普通的菜肴，但是能够做好也是不容易的，如何才能保持土豆丝熟而脆爽是关键，这个和土豆的选择、土豆丝的处理、炒制时的时间火候的把握有密切的关系。土豆最好选择含水量高的新土豆，土豆丝要过水，炒制时大火快炒勤翻动，掌握了这些窍门相信你也能做出饭店水平。 做酸辣土豆丝我喜欢用陈醋而不是白醋来烹制，虽然颜色稍深，但是陈醋的香味远比白醋来的醇厚，尽管用白醋来烹制土豆丝的色泽好看，但是白醋的味道感觉太过妖艳，自己吃的菜我会以味道为先来选择食材。","ingredients":"土豆,500g;干辣椒,2个;香菜梗,3g","burden":"大蒜,5g;盐,3/4小勺;大葱,5g;味精,1/4小勺;陈醋,1大勺","albums":["http://juheimg.oss-cn-hangzhou.aliyuncs.com/cookbook/t/0/25_843544.jpg"],"steps":[{"img":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/cookbook/s/1/25_9ef4fe27960f943f.jpg","step":"1.所有原料准备好，清洗干净。"},{"img":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/cookbook/s/1/25_c4801d7b28ab874f.jpg","step":"2.土豆丝去皮切成丝，用清水洗净表面的淀粉，再浸泡5分钟。"},{"img":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/cookbook/s/1/25_8a8179ca02be7fbd.jpg","step":"3.葱蒜切片，干辣椒斜切成段，香菜梗切段。"},{"img":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/cookbook/s/1/25_f2ec4bb90825a255.jpg","step":"4.起油锅，油温升至4成热时放入干辣椒、葱蒜片爆香。"},{"img":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/cookbook/s/1/25_10abc27a04511833.jpg","step":"5.放入土豆丝。"},{"img":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/cookbook/s/1/25_557e2a1b072469b6.jpg","step":"6.加入盐。"},{"img":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/cookbook/s/1/25_ac31d1f41af9e34f.jpg","step":"7.再加入陈醋。"},{"img":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/cookbook/s/1/25_e977f05fa6a28fc0.jpg","step":"8.开大火快速翻炒，直至土豆丝8成熟关火，放入香菜段和味精快速炒匀出锅。"}]}]}
     */

    private String resultcode;
    private String reason;
    private ResultBean result;

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        @Override
        public String toString() {
            return "ResultBean{" +
                    "data=" + data +
                    '}';
        }

        /**
         * id : 25
         * title : 酸辣土豆丝
         * tags : 家常菜;热菜;增肥;酸辣;炒;秋季养生;秋季菜谱;健脾;祛风散寒;祛寒;健脾胃;助睡眠;脾虚
         * imtro : 酸辣土豆丝可谓是人见人爱的一道家常菜，虽然价格便宜但是酸辣可口味道味道却是大家喜爱的。无论是家庭餐桌、还是饭馆酒店几乎都能见到它的身影，虽然酸辣土豆丝是一道普通的菜肴，但是能够做好也是不容易的，如何才能保持土豆丝熟而脆爽是关键，这个和土豆的选择、土豆丝的处理、炒制时的时间火候的把握有密切的关系。土豆最好选择含水量高的新土豆，土豆丝要过水，炒制时大火快炒勤翻动，掌握了这些窍门相信你也能做出饭店水平。 做酸辣土豆丝我喜欢用陈醋而不是白醋来烹制，虽然颜色稍深，但是陈醋的香味远比白醋来的醇厚，尽管用白醋来烹制土豆丝的色泽好看，但是白醋的味道感觉太过妖艳，自己吃的菜我会以味道为先来选择食材。
         * ingredients : 土豆,500g;干辣椒,2个;香菜梗,3g
         * burden : 大蒜,5g;盐,3/4小勺;大葱,5g;味精,1/4小勺;陈醋,1大勺
         * albums : ["http://juheimg.oss-cn-hangzhou.aliyuncs.com/cookbook/t/0/25_843544.jpg"]
         * steps : [{"img":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/cookbook/s/1/25_9ef4fe27960f943f.jpg","step":"1.所有原料准备好，清洗干净。"},{"img":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/cookbook/s/1/25_c4801d7b28ab874f.jpg","step":"2.土豆丝去皮切成丝，用清水洗净表面的淀粉，再浸泡5分钟。"},{"img":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/cookbook/s/1/25_8a8179ca02be7fbd.jpg","step":"3.葱蒜切片，干辣椒斜切成段，香菜梗切段。"},{"img":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/cookbook/s/1/25_f2ec4bb90825a255.jpg","step":"4.起油锅，油温升至4成热时放入干辣椒、葱蒜片爆香。"},{"img":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/cookbook/s/1/25_10abc27a04511833.jpg","step":"5.放入土豆丝。"},{"img":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/cookbook/s/1/25_557e2a1b072469b6.jpg","step":"6.加入盐。"},{"img":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/cookbook/s/1/25_ac31d1f41af9e34f.jpg","step":"7.再加入陈醋。"},{"img":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/cookbook/s/1/25_e977f05fa6a28fc0.jpg","step":"8.开大火快速翻炒，直至土豆丝8成熟关火，放入香菜段和味精快速炒匀出锅。"}]
         */

        private List<DataBean> data;

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            private String id;
            private String title;
            private String tags;
            private String imtro;
            private String ingredients;
            private String burden;
            private List<String> albums;
            /**
             * img : http://juheimg.oss-cn-hangzhou.aliyuncs.com/cookbook/s/1/25_9ef4fe27960f943f.jpg
             * step : 1.所有原料准备好，清洗干净。
             */

            private List<StepsBean> steps;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getTags() {
                return tags;
            }

            public void setTags(String tags) {
                this.tags = tags;
            }

            public String getImtro() {
                return imtro;
            }

            public void setImtro(String imtro) {
                this.imtro = imtro;
            }

            public String getIngredients() {
                return ingredients;
            }

            public void setIngredients(String ingredients) {
                this.ingredients = ingredients;
            }

            public String getBurden() {
                return burden;
            }

            public void setBurden(String burden) {
                this.burden = burden;
            }

            public List<String> getAlbums() {
                return albums;
            }

            public void setAlbums(List<String> albums) {
                this.albums = albums;
            }

            public List<StepsBean> getSteps() {
                return steps;
            }

            public void setSteps(List<StepsBean> steps) {
                this.steps = steps;
            }

            @Override
            public String toString() {
                return "DataBean{" +
                        "id='" + id + '\'' +
                        ", title='" + title + '\'' +
                        ", tags='" + tags + '\'' +
                        ", imtro='" + imtro + '\'' +
                        ", ingredients='" + ingredients + '\'' +
                        ", burden='" + burden + '\'' +
                        ", albums=" + albums +
                        ", steps=" + steps +
                        '}';
            }

            public static class StepsBean {
                private String img;
                private String step;

                public String getImg() {
                    return img;
                }

                public void setImg(String img) {
                    this.img = img;
                }

                public String getStep() {
                    return step;
                }

                public void setStep(String step) {
                    this.step = step;
                }
            }
        }
    }
}
