package com.signette.service;

import com.signette.domains.Address;

public interface AddressService extends  GlobalService<Address, Long>{
    Address addAdresse(Address adresse);
}
