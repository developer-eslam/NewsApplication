package model;

import java.io.Serializable;
import java.util.List;




    public  class sources implements Serializable{
        private String id;
        private String name;
        private String description;
        private String url;
        private String category;
        private String language;
        private String country;
        private String small;
        private String medium;
        private String large;


        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }

        public sources(String id,String small){
            setId(id);
            setSmall(small);

        }
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }


//        private List<urlsToLogos>urlsToLogoses;
//
//        public List<urlsToLogos> getUrlsToLogoses() {
//            return urlsToLogoses;
//        }
//
//        public void setUrlsToLogoses(List<urlsToLogos> urlsToLogoses) {
//            this.urlsToLogoses = urlsToLogoses;
//        }

//        public static class urlsToLogos{
//            private String small;
//            private String medium;
//            private String large;
//
//            public String getSmall() {
//                return small;
//            }
//
//            public void setSmall(String small) {
//                this.small = small;
//            }
//
//            public String getMedium() {
//                return medium;
//            }
//
//            public void setMedium(String medium) {
//                this.medium = medium;
//            }
//
//            public String getLarge() {
//                return large;
//            }
//
//            public void setLarge(String large) {
//                this.large = large;
//            }
//        }
    }

