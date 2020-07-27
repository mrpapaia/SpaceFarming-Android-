package com.example.spacefarming.entidades;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Abastecer implements Serializable , Parcelable {
	private Fornecedor fornecedor;
	private Double nivelAnterior;
	private Double nivelAtual;
	private Double precoLitro;
	private String data;
	private Responsavel responsavel;
	private String botijao;

	public Abastecer() {

	}

	public Abastecer(Fornecedor fornecedor, Double nivelAnterior, Double nivelAtual, Double precoLitro, String data,
			Responsavel responsavel, String botijao) {
		super();
		this.fornecedor = fornecedor;
		this.nivelAnterior = nivelAnterior;
		this.nivelAtual = nivelAtual;
		this.precoLitro = precoLitro;
		this.data = data;
		this.responsavel = responsavel;
		this.botijao = botijao;
	}

	protected Abastecer(Parcel in) {
		if (in.readByte() == 0) {
			nivelAnterior = null;
		} else {
			nivelAnterior = in.readDouble();
		}
		if (in.readByte() == 0) {
			nivelAtual = null;
		} else {
			nivelAtual = in.readDouble();
		}
		if (in.readByte() == 0) {
			precoLitro = null;
		} else {
			precoLitro = in.readDouble();
		}
		fornecedor= (Fornecedor) in.readSerializable();
		responsavel=(Responsavel) in.readSerializable();
		data = in.readString();

		botijao = in.readString();
	}

	public static final Creator<Abastecer> CREATOR = new Creator<Abastecer>() {
		@Override
		public Abastecer createFromParcel(Parcel in) {
			return new Abastecer(in);
		}

		@Override
		public Abastecer[] newArray(int size) {
			return new Abastecer[size];
		}
	};

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Double getNivelAnterior() {
		return nivelAnterior;
	}

	public void setNivelAnterior(Double nivelAnterior) {
		this.nivelAnterior = nivelAnterior;
	}


	public Double getNivelAtual() {
		return nivelAtual;
	}

	public void setNivelAtual(Double nivelAtual) {
		this.nivelAtual = nivelAtual;
	}

	public Double getPrecoLitro() {
		return precoLitro;
	}

	public void setPrecoLitro(Double precoLitro) {
		this.precoLitro = precoLitro;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}

	public String getBotijao() {
		return botijao;
	}

	public void setBotijao(String botijao) {
		this.botijao = botijao;
	}


	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		if (nivelAnterior == null) {
			dest.writeByte((byte) 0);
		} else {
			dest.writeByte((byte) 1);
			dest.writeDouble(nivelAnterior);
		}
		if (nivelAtual == null) {
			dest.writeByte((byte) 0);
		} else {
			dest.writeByte((byte) 1);
			dest.writeDouble(nivelAtual);
		}
		if (precoLitro == null) {
			dest.writeByte((byte) 0);
		} else {
			dest.writeByte((byte) 1);
			dest.writeDouble(precoLitro);
		}

		dest.writeSerializable(fornecedor);
		dest.writeSerializable(responsavel);
		dest.writeString(data);
		dest.writeString(botijao);
	}

	@Override
	public String toString() {
		return "Abastecer{" +
				"fornecedor=" + fornecedor +
				", nivelAnterior=" + nivelAnterior +
				", nivelAtual=" + nivelAtual +
				", precoLitro=" + precoLitro +
				", data='" + data + '\'' +
				", responsavel=" + responsavel +
				", botijao='" + botijao + '\'' +
				'}';
	}
}
