package com.address.action;

import com.address.model.AddressDTO;
import com.address.model.ZipcodeDTO;

import java.util.ArrayList;

public interface SAddressDAO {
    // 추가
    void addrInsert(AddressDTO address);

    // 전체보기
    ArrayList<AddressDTO> getAddressList();

    // 상세보기
    AddressDTO getAddressView(int num);

    // 수정
    void addrUpdate(AddressDTO addressDTO);

    // 삭제
    void addrDelete(int num);

    // 개수
    int getCount();

    // 검색
    ArrayList<AddressDTO> getAddressSearch(String field, String word);

    // 검색포함 개수
    int getSearchCount(String field, String word);

    // 우편번호 검색
    ArrayList<ZipcodeDTO> getZipcodeRead(String dong);
}
