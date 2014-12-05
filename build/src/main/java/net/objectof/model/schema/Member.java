package net.objectof.model.schema;

import net.objectof.model.Resource;

@net.objectof.Selector("Schema.members.member")
public interface Member
{
  @net.objectof.Selector("category")
  public Category getCategory();

  //category is public
  @net.objectof.Selector("pathname")
  public String getPathname();

  //pathname is public
  @net.objectof.Selector("index")
  public Long getIndex();

  //index is public
  @net.objectof.Selector("properties")
  public net.objectof.aggr.Mapping<String,net.objectof.model.schema.Property> getProperties();

  //properties is public

  public Resource<?> asResource();

}
