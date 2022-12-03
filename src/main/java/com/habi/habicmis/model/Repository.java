package com.habi.habicmis.model;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Repository {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NonNull
	private String name;

	private Boolean capabilityGetDescendents = false;

	Boolean capabilityGetFolderTree  = false;

	enum CapabiltyOrderBy {
		NONE, COMMON, CUSTOM
	};

	private CapabiltyOrderBy capabiltyOrderBy= CapabiltyOrderBy.NONE;

	enum CapabilityContentStreamUpdateability {
		NONE, ANYTIME, PWCONLY
	};

	private CapabilityContentStreamUpdateability capabilityContentStreamUpdateability = CapabilityContentStreamUpdateability.NONE;

	enum CapabilityChanges {
		NONE, OBJECTIDSONLY, PROPERTIES, ALL
	}

	private CapabilityChanges capabilityChanges = CapabilityChanges.NONE;

	enum CapabilityRenditions {
		NONE, READ
	};

	private CapabilityRenditions capabilityRenditions = CapabilityRenditions.NONE;

	private Boolean capabilityNultifiling = false;

	private Boolean capabilityUnfiling = false;

	private Boolean capabilityVersionSpecificFiling = false;

	private Boolean pWCUpdateable = false;

	private Boolean pWCSearchable = false;

	private Boolean capabilityAllVersionsSearchable = false;

	enum CapabilityQuery {
		NONE, METADATAONLY, FULLTEXTONLY, BOTHSEPARATE, BOTHCOMBINED
	}

	private CapabilityQuery capabilityQuery = CapabilityQuery.NONE;

	Boolean capabilityCreatablePropertyTypes = false;

	Boolean capabilityNewTypeSetttableAttributes = false;

	enum CapabilityACL {
		NONE, DISCOVER, MANAGE
	};

	private CapabilityACL capabilityACL= CapabilityACL.NONE;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getCapabilityGetDescendents() {
		return capabilityGetDescendents;
	}

	public void setCapabilityGetDescendents(Boolean capabilityGetDescendents) {
		this.capabilityGetDescendents = capabilityGetDescendents;
	}

	public Boolean getCapabilityGetFolderTree() {
		return capabilityGetFolderTree;
	}

	public void setCapabilityGetFolderTree(Boolean capabilityGetFolderTree) {
		this.capabilityGetFolderTree = capabilityGetFolderTree;
	}

	public CapabiltyOrderBy getCapabiltyOrderBy() {
		return capabiltyOrderBy;
	}

	public void setCapabiltyOrderBy(CapabiltyOrderBy capabiltyOrderBy) {
		this.capabiltyOrderBy = capabiltyOrderBy;
	}

	public CapabilityContentStreamUpdateability getCapabilityContentStreamUpdateability() {
		return capabilityContentStreamUpdateability;
	}

	public void setCapabilityContentStreamUpdateability(
			CapabilityContentStreamUpdateability capabilityContentStreamUpdateability) {
		this.capabilityContentStreamUpdateability = capabilityContentStreamUpdateability;
	}

	public CapabilityChanges getCapabilityChanges() {
		return capabilityChanges;
	}

	public void setCapabilityChanges(CapabilityChanges capabilityChanges) {
		this.capabilityChanges = capabilityChanges;
	}

	public CapabilityRenditions getCapabilityRenditions() {
		return capabilityRenditions;
	}

	public void setCapabilityRenditions(CapabilityRenditions capabilityRenditions) {
		this.capabilityRenditions = capabilityRenditions;
	}

	public Boolean getCapabilityNultifiling() {
		return capabilityNultifiling;
	}

	public void setCapabilityNultifiling(Boolean capabilityNultifiling) {
		this.capabilityNultifiling = capabilityNultifiling;
	}

	public Boolean getCapabilityUnfiling() {
		return capabilityUnfiling;
	}

	public void setCapabilityUnfiling(Boolean capabilityUnfiling) {
		this.capabilityUnfiling = capabilityUnfiling;
	}

	public Boolean getCapabilityVersionSpecificFiling() {
		return capabilityVersionSpecificFiling;
	}

	public void setCapabilityVersionSpecificFiling(Boolean capabilityVersionSpecificFiling) {
		this.capabilityVersionSpecificFiling = capabilityVersionSpecificFiling;
	}

	public Boolean getpWCUpdateable() {
		return pWCUpdateable;
	}

	public void setpWCUpdateable(Boolean pWCUpdateable) {
		this.pWCUpdateable = pWCUpdateable;
	}

	public Boolean getpWCSearchable() {
		return pWCSearchable;
	}

	public void setpWCSearchable(Boolean pWCSearchable) {
		this.pWCSearchable = pWCSearchable;
	}

	public Boolean getCapabilityAllVersionsSearchable() {
		return capabilityAllVersionsSearchable;
	}

	public void setCapabilityAllVersionsSearchable(Boolean capabilityAllVersionsSearchable) {
		this.capabilityAllVersionsSearchable = capabilityAllVersionsSearchable;
	}

	public CapabilityQuery getCapabilityQuery() {
		return capabilityQuery;
	}

	public void setCapabilityQuery(CapabilityQuery capabilityQuery) {
		this.capabilityQuery = capabilityQuery;
	}

	public Boolean getCapabilityCreatablePropertyTypes() {
		return capabilityCreatablePropertyTypes;
	}

	public void setCapabilityCreatablePropertyTypes(Boolean capabilityCreatablePropertyTypes) {
		this.capabilityCreatablePropertyTypes = capabilityCreatablePropertyTypes;
	}

	public Boolean getCapabilityNewTypeSetttableAttributes() {
		return capabilityNewTypeSetttableAttributes;
	}

	public void setCapabilityNewTypeSetttableAttributes(Boolean capabilityNewTypeSetttableAttributes) {
		this.capabilityNewTypeSetttableAttributes = capabilityNewTypeSetttableAttributes;
	}

	public CapabilityACL getCapabilityACL() {
		return capabilityACL;
	}

	public void setCapabilityACL(CapabilityACL capabilityACL) {
		this.capabilityACL = capabilityACL;
	}

	
}
