package com.myproject.ssm.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;
import com.myproject.ssm.crm.dal.common.object.SysMenuPrivilegeDO;

/**
 * 模拟创建一个链表数据结构，实现基本操作及后续扩展
 * 
 * @author xfcAdmin
 */
public class ArrayListDemo {

	private final static String[] modules = { "comapny", "company", "company", "add", "company", "update", "user",
			"user", "user", "add", "group", "group", "customer", "customer", "customer", "select" };

	public static void modules2List(String[] arr) {
		int len = arr.length;
		int index = 0;
		SysMenuPrivilegeDO privilege = null;
		List<SysMenuPrivilegeDO> list = new ArrayList<SysMenuPrivilegeDO>();
		System.out.println("list:" + CollectionUtils.isEmpty(list));
		for (int i = 0; i < len; i++) {
			if (index % 2 == 0) {
				privilege = new SysMenuPrivilegeDO();
				privilege.setMenuModule(arr[i]);
			} else {
				privilege.setMenuPrivilege(arr[i]);
				list.add(privilege);
			}
			index++;
		}

		for (SysMenuPrivilegeDO tmp : list) {
			System.out.println(tmp.getMenuModule() + "-----" + tmp.getMenuPrivilege());
		}
	}

	public static void main(String[] args) {
		MyLinkList<String> myList = new MyLinkList<String>();
		myList.addTail("a");
		myList.addTail("b");
		myList.addTail("c");
		myList.addTail("d");
		myList.addTail("e");

		System.out.println();

		modules2List(modules);

	}
}

class MyLinkList<T> {

	private Node<T> head;
	private int size;

	public MyLinkList() {
		head = new Node<T>();
		size = 0;
	}

	public MyLinkList(T data) {
		head = new Node<T>();
		Node<T> newNode = new Node<T>(data, null);
		head.setNext(newNode);
		size = 1;
	}

	/**
	 * 
	 * @param data
	 * @return
	 */
	public int addHead(T data) {
		// 使用头插法,反序
		if (head.getNext() == null) {
			head.setNext(new Node<T>(data, null));
		} else {
			head.setNext(new Node<T>(data, head.getNext()));
		}
		size++;
		return 1;
	}

	public int addTail(T data) {
		// 尾插法，正序排列
		if (head.getNext() == null) {
			head.setNext(new Node<T>(data, null));
		} else {
			Node<T> e = head.getNext();
			Node<T> preNode = null;
			while (e != null) {
				preNode = e;
				e = e.getNext();
			}
			e = new Node<T>(data, null);
			preNode.setNext(e);
		}
		size++;
		return 1;
	}

	/**
	 * 链表拥有的元素个数
	 * 
	 * @return
	 */
	public int size() {
		return size;
	}

	/**
	 * 获取指定index位置处的元素
	 * 
	 * @param index
	 * @return
	 */
	public T get(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}

		return null;
	}

	@Override
	public String toString() {
		return "MyLinkList [head=" + head.toString() + ", size=" + size + "]";
	}

}

class Node<E> {

	private E data;
	private Node<E> next;

	public Node() {
		this.data = null;
		this.next = null;
	}

	public Node(E data, Node<E> next) {
		this.data = data;
		this.next = next;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public Node<E> getNext() {
		return next;
	}

	public void setNext(Node<E> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	}

}
