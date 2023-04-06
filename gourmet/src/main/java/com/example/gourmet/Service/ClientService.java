package com.example.gourmet.Service;

import com.example.gourmet.Dto.ClientDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientService {

    ClientDTO registerClient(ClientDTO clientDTO);
    List<ClientDTO> findAllClient();
    ClientDTO findClient(Long id);
    ClientDTO updateClient(Long id, ClientDTO clientDTO);
    void deleteClient(Long id);

}
