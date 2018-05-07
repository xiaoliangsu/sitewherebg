package model;

public class Test
{
    private General general;

    private Java java;

    public Test(){}
    public void setGeneral(General general){
        this.general = general;
    }
    public General getGeneral(){
        return this.general;
    }
    public void setJava(Java java){
        this.java = java;
    }
    public Java getJava(){
        return this.java;
    }
    public static class Java {
        private String jvmVendor;

        private String jvmVersion;

        private int jvmFreeMemory;

        private String jvmFreeMemoryHistory;

        private int jvmTotalMemory;

        private String jvmTotalMemoryHistory;

        private int jvmMaxMemory;

        public Java(){}
        public void setJvmVendor(String jvmVendor){
            this.jvmVendor = jvmVendor;
        }
        public String getJvmVendor(){
            return this.jvmVendor;
        }
        public void setJvmVersion(String jvmVersion){
            this.jvmVersion = jvmVersion;
        }
        public String getJvmVersion(){
            return this.jvmVersion;
        }
        public void setJvmFreeMemory(int jvmFreeMemory){
            this.jvmFreeMemory = jvmFreeMemory;
        }
        public int getJvmFreeMemory(){
            return this.jvmFreeMemory;
        }
        public void setJvmFreeMemoryHistory(String jvmFreeMemoryHistory){
            this.jvmFreeMemoryHistory = jvmFreeMemoryHistory;
        }
        public String getJvmFreeMemoryHistory(){
            return this.jvmFreeMemoryHistory;
        }
        public void setJvmTotalMemory(int jvmTotalMemory){
            this.jvmTotalMemory = jvmTotalMemory;
        }
        public int getJvmTotalMemory(){
            return this.jvmTotalMemory;
        }
        public void setJvmTotalMemoryHistory(String jvmTotalMemoryHistory){
            this.jvmTotalMemoryHistory = jvmTotalMemoryHistory;
        }
        public String getJvmTotalMemoryHistory(){
            return this.jvmTotalMemoryHistory;
        }
        public void setJvmMaxMemory(int jvmMaxMemory){
            this.jvmMaxMemory = jvmMaxMemory;
        }
        public int getJvmMaxMemory(){
            return this.jvmMaxMemory;
        }

    }
    public static  class General {
        private String edition;

        private String editionIdentifier;

        private String versionIdentifier;

        private String buildTimestamp;

        private int uptime;

        private String operatingSystemName;

        private String operatingSystemVersion;

        public General(){}
        public void setEdition(String edition){
            this.edition = edition;
        }
        public String getEdition(){
            return this.edition;
        }
        public void setEditionIdentifier(String editionIdentifier){
            this.editionIdentifier = editionIdentifier;
        }
        public String getEditionIdentifier(){
            return this.editionIdentifier;
        }
        public void setVersionIdentifier(String versionIdentifier){
            this.versionIdentifier = versionIdentifier;
        }
        public String getVersionIdentifier(){
            return this.versionIdentifier;
        }
        public void setBuildTimestamp(String buildTimestamp){
            this.buildTimestamp = buildTimestamp;
        }
        public String getBuildTimestamp(){
            return this.buildTimestamp;
        }
        public void setUptime(int uptime){
            this.uptime = uptime;
        }
        public int getUptime(){
            return this.uptime;
        }
        public void setOperatingSystemName(String operatingSystemName){
            this.operatingSystemName = operatingSystemName;
        }
        public String getOperatingSystemName(){
            return this.operatingSystemName;
        }
        public void setOperatingSystemVersion(String operatingSystemVersion){
            this.operatingSystemVersion = operatingSystemVersion;
        }
        public String getOperatingSystemVersion(){
            return this.operatingSystemVersion;
        }

    }
}
