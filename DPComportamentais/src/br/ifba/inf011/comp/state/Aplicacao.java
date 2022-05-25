package br.ifba.inf011.comp.state;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import br.ifba.inf011.comp.state.ControladorGenerico.Snapshot;

public class Aplicacao {
	
	public void rodar() throws Exception{
	
		Map<Integer, Snapshot> snapshots = new HashMap<Integer, Snapshot>();
		Map<Integer, SnapshotIF> snapshots2 = new HashMap<Integer, SnapshotIF>();
		int iCont = 0;
		
		Stack<Snapshot> stk = new Stack<Snapshot>();
		Stack<SnapshotIF> stk2 = new Stack<SnapshotIF>();
		
		
		
		ControleIF controle = new ControladorGenerico(3, 35.0, System.out);
		Ambiente ambiente = new Ambiente(27.0);
		
		while(controle.getEnergy() > 0) {
			
			if(iCont % 50 == 0) {
				Snapshot snapshot = controle.checkpoint();
				SnapshotIF snapshotIF = controle.checkpoint2IF();
				snapshots.put(snapshot.getId(), snapshot);
				snapshots2.put(snapshotIF.getId(), snapshotIF);
				stk.push(snapshot);
				stk2.push(snapshotIF);
			}	
			
			ambiente.randomizar();
			System.out.println(ambiente.getTemperatura());
			controle.controlar(ambiente);
			iCont++;
		}
		
//		controle.restore(snapshots.get(1000));
		controle.restoreFromIF(stk2.pop());
		
		System.out.println("\n\n\tResumo");
		controle.printResumo(System.out);
		
		controle.restoreFromIF(stk2.pop());
		
		System.out.println("\n\n\tResumo");
		controle.printResumo(System.out);
		
	}

	
	
	public static void main(String[] args) throws Exception {
		(new Aplicacao()).rodar();
	}

}
