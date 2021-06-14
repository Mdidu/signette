package com.signette.service;

import com.signette.domains.Address;

public interface AddressService extends  GlobalService<Address>{
    Address addAdresse(Address adresse);
}
