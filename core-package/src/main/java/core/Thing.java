package core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="thing", schema="example@cassandra")
public class Thing {
	@Id
	@Column(name="id")
    private long id;

	@Column(name="title")
	private String title;
	
	@Column(name="nothing")
	private Long nothing;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getNothing() {
		return nothing;
	}

	public void setNothing(Long nothing) {
		this.nothing = nothing;
	}
}