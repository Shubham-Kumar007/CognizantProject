package com.consultancy_service.service;

import com.consultancy_service.entity.Candidate;
import com.consultancy_service.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
/* Candidate Service Method
Code
*/
@Service
@EnableScheduling
public class CandidateService {

    private final CandidateRepository candidateRepository;
    @Value("${csv.path}")
    String csvPath;
   @Autowired
    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }
    String line="";

   /*  Loading the CSV files and  tranferring data in CSV file

  post url:
  https://localhost:8001/candidate
  Zuul Post url:
  https://localhost:8765/Service1/candiate

   */
  @Scheduled(cron="${cron}")
    public void saveCandidate() {
       try{
           File[] files=new File(csvPath).listFiles(obj->obj.isFile()&&obj.getName().endsWith(".csv"));
           for(File filename:files){
           BufferedReader br= new BufferedReader(new FileReader(filename));
           SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
           while((line= br.readLine())!=null){
               String[] data= line.split(",");
               Candidate c1= new Candidate();
            c1.setFirstName(data[0]);
            c1.setLastName(data[1]);
            c1.setUniversityRegistrationNo(Long.parseLong(data[2]));
            c1.setEmailId(data[3]);
            c1.setMobile_no(data[4]);
            java.util.Date date= formatter.parse(data[5]);
            java.sql.Date sqlDate=  new java.sql.Date(date.getTime());
            c1.setDate_of_birth(sqlDate);
            c1.setGender(data[6]);
            c1.setNationality(data[7]);
            c1.setHighest_qualification(data[8]);
            c1.setCollege_name(data[9]);
            c1.setBranch(data[10]);
            c1.setYear_of_passing(Integer.parseInt(data[11]));
            c1.setGap_in_education(Integer.parseInt(data[12]));
            c1.setStanding_backlog(Integer.parseInt(data[13]));
            c1.setPercentage(Float.parseFloat(data[14]));
               java.util.Date date1= formatter.parse(data[15]);
               java.sql.Date sqlDate1=  new java.sql.Date(date1.getTime());
            c1.setDate_of_application(sqlDate1);
            c1.setTech1(data[16]);
            c1.setTech2(data[17]);
            c1.setRole(data[18]);
               this.candidateRepository.save(c1);
           }
           }
       }
       catch(Exception e){
           e.printStackTrace();
       }
    }
    /* Method used to fetch all the Records from database
    url:-http://localhost:8000/candidate
    Zuul url: http://localhost:8765/Service1/candidate
    */
    public List<Candidate> getCandidates(){
        return this.candidateRepository.findAll();
    }

/* Method used to  get of Candidates by passing role and array of technology
url: http://localhost:8000/candidate/role/{tech1,tech2}
Sample url: http://localhost:8000/candidate/FrontendDeveloper/Java,Go
Zuule Url:  http://localhost:8765/Service1/candidate/FrontendDeveloper/Java,Go
*/
    public List<Candidate> getCandidateByTechnologyInfo(String role,String[] tech1){
       List<Candidate> candidates= new ArrayList<>();
       for(String tech:tech1){
           List<Candidate> c4= this.candidateRepository.findCandidateByRoleAndTech1(role,tech);
           for(Candidate c:c4){
              candidates.add(c);
           }
       }
       return candidates;
    }
}
