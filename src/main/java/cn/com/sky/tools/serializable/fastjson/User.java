package cn.com.sky.tools.serializable.fastjson;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

public class User {

	public String username = "";
	public int id = 0;
	public ArrayList<Link> link = null;
	public Map<String, Link> result = null;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Link> getLink() {
		return link;
	}

	public void setLink(ArrayList<Link> link) {
		this.link = link;
	}

	public Map<String, Link> getResult() {
		return result;
	}

	public void setResult(Map<String, Link> result) {
		this.result = result;
	}
}
