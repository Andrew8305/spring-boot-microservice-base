package jp.drjoy.service.mobile.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class SampleItem {

    @ApiModelProperty(value = "The id.", required = true)
    private String id;

    @ApiModelProperty(value="The name.")
    private String name;

    @ApiModelProperty(value="The other name.")
    @JsonProperty(value="other-name")
    private String otherName;

    @ApiModelProperty(value="Hidden property.", hidden = true)
    @JsonIgnore
    private String hiddenProperty;

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

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public String getHiddenProperty() {
        return hiddenProperty;
    }

    public void setHiddenProperty(String hiddenProperty) {
        this.hiddenProperty = hiddenProperty;
    }

    @Override public String toString() {
        return "SampleItem{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", otherName='" + otherName + '\'' +
                ", hiddenProperty='" + hiddenProperty + '\'' +
                '}';
    }
}
