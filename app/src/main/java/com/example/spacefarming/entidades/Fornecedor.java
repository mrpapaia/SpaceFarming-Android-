package com.example.spacefarming.entidades;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Fornecedor implements Serializable, Parcelable {
	private String nome;
	private String telefone;
	private String endereco;

	public Fornecedor() {

	}

	public Fornecedor(String nome, String telefone, String endereco) {

		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	protected Fornecedor(Parcel in) {
		nome = in.readString();
		telefone = in.readString();
		endereco = in.readString();
	}

	public static final Creator<Fornecedor> CREATOR = new Creator<Fornecedor>() {
		@Override
		public Fornecedor createFromParcel(Parcel in) {
			return new Fornecedor(in);
		}

		@Override
		public Fornecedor[] newArray(int size) {
			return new Fornecedor[size];
		}
	};

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Fornecedor{" +
				"nome='" + nome + '\'' +
				", telefone='" + telefone + '\'' +
				", endereco='" + endereco + '\'' +
				'}';
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(nome);
		dest.writeString(telefone);
		dest.writeString(endereco);
	}
}
