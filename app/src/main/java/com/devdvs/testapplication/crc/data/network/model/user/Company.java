package com.devdvs.testapplication.crc.data.network.model.user;

/**
 * Created by Sánchez Deivis on 12,febrero,2023
 */
public class Company {
        private String name;
        private String catchPhrase;
        private String bs;

        public Company() {
        }

        public Company(String name, String catchPhrase, String bs) {
                this.name = name;
                this.catchPhrase = catchPhrase;
                this.bs = bs;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getCatchPhrase() {
                return catchPhrase;
        }

        public void setCatchPhrase(String catchPhrase) {
                this.catchPhrase = catchPhrase;
        }

        public String getBs() {
                return bs;
        }

        public void setBs(String bs) {
                this.bs = bs;
        }
}