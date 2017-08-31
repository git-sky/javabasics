package cn.com.sky.ldap;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.ModificationItem;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

/**
 *
 * 对ldap操作的简易工具类
 */
public class LdapUtils extends BaseLdap {

	/**
	 *
	 * @Description 创建新用户
	 * @param rootElement
	 *            某节点路径（将在此节点下创建）
	 * @param newUserName
	 *            名称
	 */
	public void add(String rootElement, String newUserName) {
		try {
			BasicAttributes attrs = new BasicAttributes();
			// 创建子节点值
			BasicAttribute objclassSet = new BasicAttribute("objectClass");
			objclassSet.add("memberOf");
			objclassSet.add("msExchVersion");
			attrs.put(objclassSet);
			attrs.put("ou", newUserName);
			dc.createSubcontext("ou=" + newUserName + "," + rootElement, attrs);
		} catch (Exception e) {
			System.out.println("新增失败:" + e);
		}
	}

	/**
	 *
	 * @Description 删除用户
	 * @param dn
	 *            账户所在的域全路径
	 */
	public void delete(String dn) {
		try {
			dc.destroySubcontext(dn);
		} catch (Exception e) {
			System.out.println("删除失败:" + e);
		}
	}

	/**
	 *
	 * @Description 更改节点名称
	 * @param oldDN
	 *            旧节点名称全路径
	 * @param newDN
	 *            新节点名称全路径
	 * @return
	 */
	public boolean renameEntry(String oldDN, String newDN) {
		try {
			dc.rename(oldDN, newDN);
			return true;
		} catch (NamingException e) {
			System.out.println("更新失败: " + e);
			return false;
		}
	}

	/**
	 *
	 * @Description 更新节点下的属性与值 (节点属性的增删改，可扩展为批量操作)
	 * @param dn
	 *            需要更新的节点全路径
	 * @param type
	 *            节点更新类型（默认0：新增，1：修改，2：删除）
	 * @param attribute
	 *            更改属性
	 * @param value
	 *            属性值
	 * @return
	 */
	public boolean modifyInformation(String dn, int type, String attribute, String value) {
		try {
			ModificationItem[] mods = new ModificationItem[1];
			Attribute attr0 = new BasicAttribute(attribute, value);
			if (type == 0) {
				mods[0] = new ModificationItem(DirContext.ADD_ATTRIBUTE, attr0);
			} else if (type == 1) {
				mods[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, attr0);
			} else if (type == 2) {
				mods[0] = new ModificationItem(DirContext.REMOVE_ATTRIBUTE, attr0);
			} else {
				System.out.println("type数据有误！");
			}
			dc.modifyAttributes(dn, mods);
			return true;
		} catch (NamingException e) {
			System.out.println("更新失败: " + e);
			return false;
		}
	}

	/**
	 *
	 * @Description 关闭ldap连接
	 */
	public void close() {
		if (dc != null) {
			try {
				dc.close();
				System.out.println("关闭ldap连接成功。。。");
			} catch (NamingException e) {
				System.out.println("关闭失败:" + e);
			}
		}
	}

	/**
	 *
	 * @Description 简单的条件查询
	 * @param base
	 *            基础节点 （dc=meixin,dc=com）
	 * @param scope
	 *            查询范围（默认0：遍历，1：单层，2：本节点）
	 * @param resultAttrutes
	 *            [] 指定查询属性（不需要指定则传递null：查询符合条件的所有属性；）
	 * @param searchFilter
	 *            查询条件（属性名=值，如："sAMAccountName=guowenbo"
	 *            查询所有sAMAccountName属性值为guowenbo的数据；"objectclass=*"默认查询全部。）
	 */
	@SuppressWarnings("rawtypes")
	public void Ldapbyuserinfo(String base, int scope, String resultAttrutes[], String searchFilter) {
		SearchControls searchCtls = new SearchControls();
		if (scope == 0) {
			// 默认
			searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);
		} else if (scope == 1) {
			searchCtls.setSearchScope(SearchControls.ONELEVEL_SCOPE);
		} else if (scope == 2) {
			searchCtls.setSearchScope(SearchControls.OBJECT_SCOPE);
		} else {
			System.out.println("查询范围数据不正确！");
			return;
		}
		int totalResults = 0;
		searchCtls.setReturningAttributes(resultAttrutes);
		try {
			NamingEnumeration answer = dc.search(base, searchFilter, searchCtls);
			if (answer == null || answer.equals(null)) {
				System.out.println("返回结果为空或查询数据不存在！");
				return;
			}
			System.out.println("查询成功！继续解析节点数据。。。");
			while (answer.hasMoreElements()) {
				SearchResult sr = (SearchResult) answer.next();
				System.out.println("已获取到信息：" + sr.getName());
				System.out.println("*****************进行遍历********************");
				Attributes Attrs = sr.getAttributes();
				if (Attrs != null) {
					try {
						for (NamingEnumeration ne = Attrs.getAll(); ne.hasMore();) {
							Attribute Attr = (Attribute) ne.next();
							System.out.println("属性名称(↓为值)：" + Attr.getID().toString());
							for (NamingEnumeration e = Attr.getAll(); e.hasMore(); totalResults++) {
								System.out.println(e.next().toString());
							}
						}
					} catch (NamingException e) {
						System.err.println("执行出错: " + e);
					}
				}
			}
			System.out.println("*****************遍历结束********************");
			System.out.println("属性总数: " + totalResults);
		} catch (Exception e) {
			System.err.println("执行出错: " + e);
		}
	}
}