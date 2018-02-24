package pe.edu.utp.jsfregionslist.beans;

import pe.edu.utp.jsfregionslist.models.HrService;
import pe.edu.utp.jsfregionslist.models.Region;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped

public class RegionsBean implements Serializable {
    private HrService service;
    private Region region;

    public RegionsBean() {
        setService(new HrService());
    }

    public List<Region> getRegions() {
        return getService().findAllRegions();
    }

    public HrService getService() {
        return service;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public String editRegion(Region region){
        this.setRegion(region);
        return "success";
    }

    public String newRegion(){
        this.setRegion(new Region());
        return "success";
    }

    public String updateRegion(){
        service.updateRegion(this.getRegion());
        return "success";
    }

    public String createRegion(){
        service.createRegion(this.getRegion().getName());
        return "success";
    }

    public String deleteRegion(Region region){
        service.deleteRegion(region.getId());
        return "success";
    }

    public void setService(HrService service) {
        this.service = service;
    }
}
