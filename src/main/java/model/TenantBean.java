package model;

import java.util.List;

public class TenantBean {
    private String id;
    private String name;
    private String authenticationToken;
    private String logoUrl;
    private List<String> authorizedUserIds;

    public String getTenantTemplateId() {
        return tenantTemplateId;
    }

    public void setTenantTemplateId(String tenantTemplateId) {
        this.tenantTemplateId = tenantTemplateId;
    }

    private  String tenantTemplateId;
    private Metadata metadata;

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }
    public Metadata getMetadata() {
        return metadata;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setAuthenticationToken(String authenticationToken) {
        this.authenticationToken = authenticationToken;
    }
    public String getAuthenticationToken() {
        return authenticationToken;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }
    public String getLogoUrl() {
        return logoUrl;
    }

    public void setAuthorizedUserIds(List<String> authorizedUserIds) {
        this.authorizedUserIds = authorizedUserIds;
    }
    public List<String> getAuthorizedUserIds() {
        return authorizedUserIds;
    }

}
