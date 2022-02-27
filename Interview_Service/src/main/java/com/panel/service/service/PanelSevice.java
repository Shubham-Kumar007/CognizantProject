package com.panel.service.service;

import com.panel.service.feign.RecruitmentFeign;
import com.panel.service.mapping.CandidatePanelInfo;
import com.panel.service.model.Candidate;
import com.panel.service.model.Panel;
import com.panel.service.repository.PanelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class PanelSevice {

    @Autowired
    private PanelRepository panelRepository;

    @Autowired
    private RecruitmentFeign recruitmentFeign;

    /*Method used to save the panel details - Post url
     url: http://localhost:8003/panel
     Zuule url: http://localhost:8765/Service3/panel
     */
    public Panel savePanel(Panel panel){
        return this.panelRepository.save(panel);
    }

/*Method is used to fetch Panel Details - Get url
        url: http://localhost:8003/panel
        Zuule url: http://localhost:8765/Service3/panel
*/
    public List<Panel> getPanels(){
        return this.panelRepository.findAll();
    }


    /*Method is used to get the CandidatePanelInfo
    Detail of Panel assigned to a candidate  along wih Candidate Detail
    url: http://localhost:8003/panel/interview
    Zuul url: http://localhost:8765/Service4/panel/interview
    */
    public List<CandidatePanelInfo> getPanelAssignedToCandid(){
        List<Panel> panel1= this.panelRepository.findAll();
        List<Candidate> candidates=   recruitmentFeign.getAllEligibleCandidates();
        List<CandidatePanelInfo> candidatePanelList= new ArrayList<>();

        for(Panel panel:panel1){
            for(Candidate candid:candidates) {
            if ( panel.isAvailable()==true) {
                if (candid.getRole().equalsIgnoreCase("FrontendDeveloper") &&
                        panel.getPanelName().equalsIgnoreCase("FrontendDeveloper")) {
                    CandidatePanelInfo candidatePanelInfo= new CandidatePanelInfo();
                                   candidatePanelInfo.setPanel(panel);
                                   candidatePanelInfo.setCandidate(candid);
                                   candidatePanelInfo.setDate_of_Interview(new Date(System.currentTimeMillis()));
                                   panel.setAvailable(false);
                                   candid.setDate_of_interview(new Date(System.currentTimeMillis()));
                                   candidatePanelList.add(candidatePanelInfo);
                }
               else if (candid.getRole().equalsIgnoreCase("BackendDeveloper") &&
                 panel.getPanelName().equalsIgnoreCase("BackendDeveloper")) {
                    CandidatePanelInfo candidatePanelInfo= new CandidatePanelInfo();
                    candidatePanelInfo.setPanel(panel);
                    candidatePanelInfo.setCandidate(candid);
                    candidatePanelInfo.setDate_of_Interview(new Date(System.currentTimeMillis()));
                    panel.setAvailable(false);
                    candid.setDate_of_interview(new Date(System.currentTimeMillis()));
                    candidatePanelList.add(candidatePanelInfo);
                }
                else if (candid.getRole().equalsIgnoreCase("FullStackDeveloper")
                        && panel.getPanelName().equalsIgnoreCase("FullStackDeveloper")) {
                    CandidatePanelInfo candidatePanelInfo= new CandidatePanelInfo();
                    candidatePanelInfo.setPanel(panel);
                    candidatePanelInfo.setCandidate(candid);
                    candidatePanelInfo.setDate_of_Interview(new Date(System.currentTimeMillis()));
                    panel.setAvailable(false);
                    candid.setDate_of_interview(new Date(System.currentTimeMillis()));
                    candidatePanelList.add(candidatePanelInfo);
                }
                else{
                    continue;
                }
            }
        }
        }
        return candidatePanelList;
    }

}
