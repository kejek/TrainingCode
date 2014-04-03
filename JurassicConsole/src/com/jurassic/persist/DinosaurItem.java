package com.jurassic.persist;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.Table;
 
@Entity
@Table(name = "Dinos")
public class DinosaurItem {
	// properties

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DINO_ID")
	private Long id;
	private String name;
	private String species;
	private int age;
	private String location;

	public DinosaurItem() {
	}

	public DinosaurItem(String name, String species, int age, String location) {
		this.setName(name);
		this.setSpecies(species);
		this.setAge(age);
		this.setLocation(location);

	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSpecies() {
		return species;
	}

	public int getAge() {
		return age;
	}

	public String getLocation() {
		return location;
	}

	@SuppressWarnings("unused")
	private void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	// override Object.equals
	public boolean equals(Object compare) {
		boolean result = false;
		DinosaurItem other = null;

		if (compare instanceof DinosaurItem) {
			// cast to DinosaurItem
			other = (DinosaurItem) compare;

			// if all the ids are equal, the objects are equal
			result = other.getId().equals(this.getId());
		}
		return result;
	}

	// override Object.toString
	public String toString() {
		return this.getId() + " | "
				+ this.getName() + " | " + this.getSpecies() + " | "
				+ this.getAge() + " | " + this.getLocation();
	}
}