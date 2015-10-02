public class Solution {
    public String addBinary(String a, String b) {
            if(a==null && b==null){
	                return null;
			        }
				        
					        if(a==null){
						            return b;
							            }
								            
									            if(b==null){
										                return a;
												        }
													        
														        int aLength=a.length();
															        int bLength=b.length();
																        int length=0;
																	        
																		        if(aLength<bLength){
																			            length=bLength+1;
																				            }else{
																					                length=aLength+1;
																							        }
																								        
																									        Stack<Character> binaryStack=new Stack();
																										        char aChar=' ';
																											        char bChar=' ';
																												        char newChar=' ';
																													        int extra=0;
																														        for(int i=1;i<=length;i++){
																															            if(aLength-i>=0){
																																                    aChar=a.charAt(aLength-i);
																																		                }else{
																																				                aChar='0';
																																						            }
																																							                
																																									            if(bLength-i>=0){
																																										                    bChar=b.charAt(bLength-i);
																																												                }else{
																																														                bChar='0';
																																																            }
																																																	                
																																																			            int aShift=aChar-'0';
																																																				                int bShift=bChar-'0';
																																																						            int sum=aShift+bShift+extra;
																																																							                
																																																									            if(sum==3){
																																																										                    binaryStack.push('1');
																																																												                    extra=1;
																																																														                }
																																																																            if(sum==2){
																																																																	                    binaryStack.push('0');
																																																																			                    extra=1;
																																																																					                }
																																																																							            if(sum==1){
																																																																								                    binaryStack.push('1');
																																																																										                    extra=0;
																																																																												                }
																																																																														            if(sum==0){
																																																																															                    binaryStack.push('0');
																																																																																	                    extra=0;
																																																																																			                }
																																																																																					        }
																																																																																						        
																																																																																							        if(binaryStack.size()>1 && binaryStack.peek()=='0'){
																																																																																								            binaryStack.pop();
																																																																																									            }
																																																																																										            
																																																																																											            StringBuffer sb=new StringBuffer();
																																																																																												            while(binaryStack.size()>0){
																																																																																													                sb.append(binaryStack.pop());
																																																																																															        }
																																																																																																        
																																																																																																	        return sb.toString();
																																																																																																		        
																																																																																																			        
																																																																																																				    }
																																																																																																				    }
