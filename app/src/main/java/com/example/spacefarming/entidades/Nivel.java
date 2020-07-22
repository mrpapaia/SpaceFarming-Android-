package com.example.spacefarming.entidades;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.Date;

public class Nivel implements Parcelable {
	private Double nivel;
	private String data;
	private Responsavel responsavel;
	private String botijao;

	public Nivel() {

	}

	public Nivel(Double nivel, String data, Responsavel responsavel, String botijao) {
		
		this.nivel = nivel;
		this.data = data;
		this.responsavel = responsavel;
		this.botijao = botijao;
	}

	protected Nivel(Parcel in) {
		if (in.readByte() == 0) {
			nivel = null;
		} else {
			nivel = in.readDouble();
		}
		data = in.readString();
		botijao = in.readString();
		responsavel=(Responsavel) in.readSerializable();
	}

	public static final Creator<Nivel> CREATOR = new Creator<Nivel>() {
		@Override
		public Nivel createFromParcel(Parcel in) {
			return new Nivel(in);
		}

		@Override
		public Nivel[] newArray(int size) {
			return new Nivel[size];
		}
	};

	public Double getNivel() {
		return nivel;
	}

	public void setNivel(Double nivel) {
		this.nivel = nivel;
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
	public String toString() {
		return "Nivel [nivel=" + nivel + ", data=" + data + ", responsavel=" + responsavel + ", botijao=" + botijao
				+ "]";
	}


	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		if (nivel == null) {
			dest.writeByte((byte) 0);
		} else {
			dest.writeByte((byte) 1);
			dest.writeDouble(nivel);
		}

		dest.writeString(data);
		dest.writeString(botijao);
		dest.writeSerializable(responsavel);
	}
}
