package com.signette.service;

import com.signette.domains.AdresseEntity;

public interface AdresseService extends  GlobalService<AdresseEntity>{
    AdresseEntity addAdresse(AdresseEntity adresse);
}
