package com.sky.service;

import com.sky.entity.AddressBook;

import java.util.List;

/**
 * @Author:guoyaqi
 * @Date: 2024/12/13 0:15
 */
public interface AddressBookService {
    AddressBook getById(Long id);

    /**
     * 查询当前的用户地址
     * @param addressBook
     */
    List<AddressBook> list(AddressBook addressBook);

    /**
     * 新增地址
     * @param addressBook
     */
    void save(AddressBook addressBook);

    /**
     * 修改地址
     * @param addressBook
     */
    void update(AddressBook addressBook);

    /**
     * 设置默认地址
     * @param addressBook
     */
    void setDefault(AddressBook addressBook);

    /**
     * 根据id删除地址
     * @param id
     */
    void deleteById(Long id);


}
