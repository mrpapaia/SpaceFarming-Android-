package com.example.spacefarming.entidades;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Responsavel implements Serializable, Parcelable {
	private String nome;
	private String telefone;
	private String email;

	
	public Responsavel() {
		
	}

	public Responsavel(String nome, String telefone, String email) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;

	}

	protected Responsavel(Parcel in) {
		nome = in.readString();
		telefone = in.readString();
		email = in.readString();
	}

	@Override
	public String toString() {
		return "Responsavel{" +
				"nome='" + nome + '\'' +
				", telefone='" + telefone + '\'' +
				", email='" + email + '\'' +
				'}';
	}

	public static final Creator<Responsavel> CREATOR = new Creator<Responsavel>() {
		@Override
		public Responsavel createFromParcel(Parcel in) {
			return new Responsavel(in);
		}

		@Override
		public Responsavel[] newArray(int size) {
			return new Responsavel[size];
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(nome);
		dest.writeString(telefone);
		dest.writeString(email);
	}
}
