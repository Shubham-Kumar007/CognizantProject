package com.panel.service.repository;

import com.panel.service.model.Panel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanelRepository extends JpaRepository<Panel,Long> {
   // Panel findPanelByPanelNameAndTechnology(String panelName,String technology);
}
