package com.alleton.adventProject.model;

public class Solver16aunt {
	private int sue;
	private int cats;
	private int samoyeds;
	private int pomeranians;
	private int akitas;
	private int vizslas;
	private int goldfish;
	private int trees;
	private int cars;
	private int perfumes;
	private int children;

	public Solver16aunt() {
		int noinfo = -1 ;
		// at start we have noinfos ..
		this.setAkitas(noinfo);
		this.setCars(noinfo);
		this.setCats(noinfo);
		this.setChildren(noinfo);
		this.setGoldfish(noinfo);
		this.setPerfumes(noinfo);
		this.setPomeranians(noinfo);
		this.setSamoyeds(noinfo);
		this.setTrees(noinfo);
		this.setVizslas(noinfo);
	}
	
	
	// Getters & Setters
	
	/**
	 * @return the sue
	 */
	public int getSue() {
		return sue;
	}
	/**
	 * @param sue the sue to set
	 */
	public void setSue(int sue) {
		this.sue = sue;
	}
	/**
	 * @return the cats
	 */
	public int getCats() {
		return cats;
	}
	/**
	 * @param cats the cats to set
	 */
	public void setCats(int cats) {
		this.cats = cats;
	}
	/**
	 * @return the samoyeds
	 */
	public int getSamoyeds() {
		return samoyeds;
	}
	/**
	 * @param samoyeds the samoyeds to set
	 */
	public void setSamoyeds(int samoyeds) {
		this.samoyeds = samoyeds;
	}
	/**
	 * @return the pomeranians
	 */
	public int getPomeranians() {
		return pomeranians;
	}
	/**
	 * @param pomeranians the pomeranians to set
	 */
	public void setPomeranians(int pomeranians) {
		this.pomeranians = pomeranians;
	}
	/**
	 * @return the akitas
	 */
	public int getAkitas() {
		return akitas;
	}
	/**
	 * @param akitas the akitas to set
	 */
	public void setAkitas(int akitas) {
		this.akitas = akitas;
	}
	/**
	 * @return the vizslas
	 */
	public int getVizslas() {
		return vizslas;
	}
	/**
	 * @param vizslas the vizslas to set
	 */
	public void setVizslas(int vizslas) {
		this.vizslas = vizslas;
	}
	/**
	 * @return the goldfish
	 */
	public int getGoldfish() {
		return goldfish;
	}
	/**
	 * @param goldfish the goldfish to set
	 */
	public void setGoldfish(int goldfish) {
		this.goldfish = goldfish;
	}
	/**
	 * @return the trees
	 */
	public int getTrees() {
		return trees;
	}
	/**
	 * @param trees the trees to set
	 */
	public void setTrees(int trees) {
		this.trees = trees;
	}
	/**
	 * @return the cars
	 */
	public int getCars() {
		return cars;
	}
	/**
	 * @param cars the cars to set
	 */
	public void setCars(int cars) {
		this.cars = cars;
	}
	/**
	 * @return the perfumes
	 */
	public int getPerfumes() {
		return perfumes;
	}
	/**
	 * @param perfumes the perfumes to set
	 */
	public void setPerfumes(int perfumes) {
		this.perfumes = perfumes;
	}
	/**
	 * @return the children
	 */
	public int getChildren() {
		return children;
	}
	/**
	 * @param children the children to set
	 */
	public void setChildren(int children) {
		this.children = children;
	}

	// for printing
	public String auntToString (){
		StringBuilder builder = new StringBuilder();
		builder.append( " Sue   =  " +  this.getSue() + "  : " ) ;
		builder.append( " Akitas    = " + this.getAkitas()  + "  : " ) ;
		builder.append( " Cars   =  " + this.getCars() + "  : " ) ;
		builder.append( " Cats   =  " + this.getCats() + "  : " ) ;
		builder.append( " Children   =  " +  this.getChildren() + "  : " ) ;
		builder.append( " Goldfish   =  " +  this.getGoldfish() + "  : " ) ;
		builder.append( " Perfumes   =  " +  this.getPerfumes() + "  : " ) ;
		builder.append( " Pomeranians   =  " +  this.getPomeranians() + "  : " ) ;
		builder.append( " Samoyeds   =  " +  this.getSamoyeds() + "  : " ) ;
		builder.append( " Trees   =  " +  this.getTrees() + "  : " ) ;
		builder.append( " Vizslas   =  " +  this.getVizslas() + "  : " ) ;
						
		//builder.append( " capacity   =  " +  t + "  : " ) ;
								
		
		return  builder.toString();
	}
	
	
}
