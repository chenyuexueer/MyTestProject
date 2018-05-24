package wlj.myapplication.mvp_demo.test.bean;

/**
 * ================================================
 * Created by ${chenyuexueer}
 * 时间： 2018/5/23.
 * 说明：
 * ================================================
 */

public class SystemVersionBean {
    /**
     * status : 200
     * code : 207
     * level : 1
     * config : 0=没有更新、1=有更新
     * msg :
     * type : 0
     * info : {"title":"花聊升级","hint":"修改部分BUG，优化体验","url":"http://cdn.huatell.com/apk/hualiao_2018020301.apk"}
     */

    private int status;
    private int code;
    private int level;
    private int config;
    private int type;
    private InfoBean info;
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getConfig() {
        return config;
    }

    public void setConfig(int config) {
        this.config = config;
    }


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
        this.info = info;
    }

    public static class InfoBean {
        /**
         * title : 花聊升级
         * hint : 修改部分BUG，优化体验
         * url : http://cdn.huatell.com/apk/hualiao_2018020301.apk
         */

        private String title;
        private String hint;
        private String url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getHint() {
            return hint;
        }

        public void setHint(String hint) {
            this.hint = hint;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    @Override
    public String toString() {
        return "SystemVersionBean{" +
                "status=" + status +
                ", code=" + code +
                ", level=" + level +
                ", config=" + config +
                ", type=" + type +
                ", info=" + info +
                ", msg='" + msg + '\'' +
                '}';
    }
}