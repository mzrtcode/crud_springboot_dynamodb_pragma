package com.example.demo.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.example.demo.model.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UsuarioRepository {

    private final DynamoDBMapper dynamoDBMapper;

    public Usuario save(Usuario usuario){
        dynamoDBMapper.save(usuario);
        return  usuario;
    }

    public Usuario getUsuarioById(String usuarioId){
        return dynamoDBMapper.load(Usuario.class, usuarioId);
    }

    public List<Usuario> findAll() {
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
        List<Usuario> usuarios = dynamoDBMapper.scan(Usuario.class, scanExpression);
        return usuarios;
    }

    public String delete(String usuarioId){
        Usuario usuario = dynamoDBMapper.load(Usuario.class, usuarioId);
        dynamoDBMapper.delete(usuario);
        return "Employee deleted!";
    }

    public String update(String usuarioId, Usuario usuario){
        Usuario load = dynamoDBMapper.load(Usuario.class, usuarioId);

        if (load == null) return "El usuario no existe";
        usuario.setUsuarioId(usuarioId);
        dynamoDBMapper.save(usuario);

        return usuarioId;
    }

}
