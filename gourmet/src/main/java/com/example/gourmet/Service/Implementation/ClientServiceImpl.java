package com.example.gourmet.Service.Implementation;

import com.example.gourmet.Dto.ClientDTO;
import com.example.gourmet.Entity.Client;
import com.example.gourmet.Repository.ClienRepository;
import com.example.gourmet.Service.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClienRepository clientRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ClientDTO registerClient(ClientDTO clientDTO) {
        Client client = modelMapper.map(clientDTO, Client.class);
        Client clientSauvegarde = clientRepository.save(client);
        return modelMapper.map(clientSauvegarde, ClientDTO.class);
    }

    @Override
    public List<ClientDTO> findAllClient() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream().map(client -> modelMapper
                .map(client, ClientDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ClientDTO findClient(Long id) {
        Optional<Client> clientOptional = clientRepository.findById(id);
        if (clientOptional.isPresent()) {
            Client client = clientOptional.get();
            return modelMapper.map(client, ClientDTO.class);
        } else {
            throw new EntityNotFoundException("Le client avec l'identifiant " + id + " n'existe pas.");
        }
    }

    @Override
    public ClientDTO updateClient(Long id, ClientDTO clientDTO) {
        Optional<Client> clientOptional = clientRepository.findById(id);
        if (clientOptional.isPresent()) {
            Client client = clientOptional.get();
            client.setNom_complet(clientDTO.getNomComplet());
            client.setEmail(clientDTO.getEmail());
            client.setAdresse(clientDTO.getAdresse());
            Client clientSauvegarde = clientRepository.save(client);
            return modelMapper.map(clientSauvegarde, ClientDTO.class);
        } else {
            throw new EntityNotFoundException("Le client avec l'identifiant " + id + " n'existe pas.");
        }
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
