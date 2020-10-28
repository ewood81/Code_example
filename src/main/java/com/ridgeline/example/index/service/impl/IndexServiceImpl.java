package com.ridgeline.example.index.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.ridgeline.example.index.exception.IndexException;
import com.ridgeline.example.index.model.interfaces.IndexModel;
import com.ridgeline.example.index.service.interfaces.IndexService;
import com.ridgeline.example.model.DivisionIndexModel;
import com.ridgeline.example.model.DivisionModel;
import com.ridgeline.example.model.TeamModel;

@Service
public class IndexServiceImpl implements IndexService {
	
	private static Logger log = LoggerFactory.getLogger(IndexServiceImpl.class);

	@Override
	public IndexModel generateIndex(Document document, XPath xpath) throws IndexException {
		DivisionIndexModel divisionIndexModel = null;
		
		log.info("Generating division index...");
		
		if (null != document) {
			try {
				Node divisionNode = document.getFirstChild();

				DivisionModel divisionModel = null;
				
				if (null != divisionNode) {
					divisionModel = new DivisionModel();

					Node divisionName = (Node) (xpath.compile("./Name")).evaluate(divisionNode, XPathConstants.NODE);

					if (null != divisionName && null != divisionName.getFirstChild()) {
						divisionModel.setName(divisionName.getFirstChild().getTextContent());
						
						log.info("Division model name set as: {}", divisionName.getFirstChild().getTextContent());
					}
					
					NodeList teamNodes = (NodeList)(xpath.compile("./Teams/Team")).evaluate(divisionNode, XPathConstants.NODESET);
					
					List<TeamModel> teamList = new ArrayList<>();
					
					TeamModel teamModel = null;
					
					if(null != teamNodes && teamNodes.getLength() > 0) {
						Node teamNode = null;
						
						log.info("{} team elements found...", teamNodes.getLength());
						
						for(int i = 0; i < teamNodes.getLength(); i++) {
							teamNode = teamNodes.item(i);
							
							if(null != teamNode) {
								teamModel = new TeamModel();
								
								Node teamName = (Node)(xpath.compile("./Name")).evaluate(teamNode, XPathConstants.NODE);
								
								if(null != teamName && null != teamName.getChildNodes()) {
									teamModel.setName(teamName.getFirstChild().getTextContent());
									
									log.info("Team name set as: {}", teamName.getFirstChild().getTextContent());
								}
								
								Node location = (Node)(xpath.compile("./Location")).evaluate(teamNode, XPathConstants.NODE);
								
								if(null != location && null != location.getChildNodes()) {
									teamModel.setLocation(location.getFirstChild().getTextContent());
									
									log.info("Team location set as: {}", location.getFirstChild().getTextContent());
								}
								
								Node ballpark = (Node)(xpath.compile("./Ballpark")).evaluate(teamNode, XPathConstants.NODE);
								
								if(null != ballpark && null != ballpark.getChildNodes()) {
									teamModel.setBallpark(ballpark.getFirstChild().getTextContent());
									
									log.info("Team ballpark set as: {}", ballpark.getFirstChild().getTextContent());
								}
								
								Node championships = (Node)(xpath.compile("./Championships")).evaluate(teamNode, XPathConstants.NODE);
								
								if(null != championships && null != championships.getChildNodes()) {
									teamModel.setChampionships(championships.getFirstChild().getTextContent());
									
									log.info("Team championships set as: {}", championships.getFirstChild().getTextContent());
								}
								
								teamList.add(teamModel);
							}
						}
					}
					divisionIndexModel = new DivisionIndexModel();
					
					divisionIndexModel.setDivisionModel(divisionModel);
					divisionIndexModel.setTeamModel(teamList);
				}
			}

			catch (Exception e) {
				log.warn("Exception of type {} was thrown!", e.getClass().getName());
				
				throw new IndexException(e.getMessage(), e.getCause());
			}

		}
		
		return divisionIndexModel;
	}
}
